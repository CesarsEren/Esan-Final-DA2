/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BEAN.ComboData;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesars Pinedo Olivera
 */
public class Conexion {

    private static Connection dbCon;
    public static String user;
    public static String password;
    public static String driver;
    public static String url;

    public Conexion() {

    }

    public boolean TestearConexion() throws ClassNotFoundException, SQLException {
        Class.forName(Conexion.driver);
        /*manejar persistencias y archivos XML*/
        dbCon = DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.password);
        //dbCon.createStatement(); 
        if (dbCon != null) {
            System.out.println("Conexión exitosa");
            // Puedes cerrar la conexión aquí si es necesario
            dbCon.close();
            return true;
        } else {
            System.out.println("No se pudo establecer la conexión");
            return false;
        }
    }

    /**
     * Jar Creada para uso y facilidad de consultas a la base de datos con
     * objetivo de acortar el codigo los datos en esta clase son de tipo Static
     * por lo tanto solo necesita usar este Constructor una vez y a las
     * siguientes ya tendra la conexion por defecto
     *
     * @author CESARS JOSE MANUEL PINEDO OLIVERA(IDAT-2018)
     * @version ver 1.0
     * @param driver Oracle(Objdc),Mysql(mysql-conector),SQL(sqljdbc4)
     * @param url ("jdbc:motorDB//ip:puerto/database name")
     * @param user nombre de el usuario en la base de datos o WorkSpace
     * @param password contraseña para ingresar a la database
     */
    public Conexion(String driver, String url, String user, String password) {
        Conexion.driver = driver;
        Conexion.url = url;
        Conexion.user = user;
        Conexion.password = password;
        try {
            Class.forName(Conexion.driver);

            /*manejar persistencias y archivos XML*/
            dbCon = DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.password);
            dbCon.createStatement();
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar" + e);
        }
    }

    public Conexion(String driver, String url) {
        Conexion.driver = driver;
        Conexion.url = url;
        try {
            Class.forName(Conexion.driver);
            dbCon = DriverManager.getConnection(Conexion.url);
            dbCon.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error al conectar" + e);
        }
    }

    /**
     * @return devuelve la conexion a la base de datos
     */
    public Connection conectardb() {
        try {
            return dbCon = DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.password);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * funcion para consultar a la DB el numero de registros de una tabla
     * mediante la consulta
     *
     * @param SQL_Consulta consulta
     * @param where condicion si es necesaria sino ingrese null
     * @return retorna un Integer numero de registros
     */
    private int numeroRegistro(String SQL_Consulta, String where) {
        SQL_Consulta = where == null ? SQL_Consulta : SQL_Consulta + " WHERE " + where;
        int registros = 0;
        try {
            PreparedStatement pstm = conectardb().prepareStatement(SQL_Consulta);
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
                System.out.println("" + SQL_Consulta);
            }
        } catch (SQLException e) {
            System.out.println("numeroRegistro " + e);

        }
        System.out.println("numero de registros" + registros);
        return registros;

    }

    /**
     *
     * funcion para consultar a la DB
     *
     * @param tabla tabla implicada
     * @param campos nombres de los campos para ver la consulta
     * @param where condicion si es necesaria sino ingrese null
     * @return retorna un Object[][] bidimensional
     */
    public Object[][] select(String tabla, String campos, String where) {
        int registros = numeroRegistro("SELECT count(*) as total FROM " + tabla, where);
        String colname[] = campos.split(",");

        for (String w1 : colname) {
            System.out.println("colnames " + w1);

        }

        int Nrocolumnas = colname.length;
        //Ternario que consulta si tiene o no tiene where
        String SQL_CONSULTA = "SELECT " + campos + " FROM " + tabla;
        String q = where == null ? SQL_CONSULTA : SQL_CONSULTA + " WHERE " + where;
        //-------------------------------------------------------------------------
        System.out.println("Query que se Ejecuta " + q);
        //-------------------------------------------------------------------------
        //----------------Captura de Tabla
        Object[][] data = new String[registros][Nrocolumnas];
        try {
            PreparedStatement pstm = conectardb().prepareStatement(q);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                for (int j = 0; j < Nrocolumnas; j++) {
                    //puedes añadir el metodo trim por si ocurre un problema con los datos y los escriben con espacios
                    String columname = colname[j];
                    System.out.println("colname : " + colname[j] + " :");
                    if (colname[j].contains(" as ")) {
                        //int tamanio = colname[j].length();
                        //columname == columname.substring(columname.indexOf(" as "), tamanio);
                        String[] foo = columname.split(" as ");
                        System.out.println("foo: " + foo.length);
                        columname = foo[1].trim();
                    }
                    data[i][j] = res.getString(columname);
                }
                i++;
            }
            res.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("select " + e);
        }
        return data;
    }

    /**
     * funcion para insertar Registros en la base de datos
     *
     * @param tabla nombre de la tabla implicada
     * @param campos campos o columnas de la tabla implicada y que ingresara
     * @param values valores que ingresara 1 x cada campo
     * @return retorna un boolean para ver si se hizo o no ademas se muestra la
     * query en un SOUT() de su consola
     */
    public boolean insert(String tabla, String campos, String values) {
        boolean res = false;
        String q = " INSERT INTO " + tabla + " (" + campos + ") VALUES (" + values + ") ";
        System.out.println("Query que se ejecuta" + q);
        try {
            PreparedStatement pstm = conectardb().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res = true;
        } catch (SQLException e) {
            System.out.println("" + e);
        }
        return res;
    }

    private String qery2(int n, String fields[], String registros[], String where) {
        String x = fields[n] + " = " + registros[n];
        return n == 0 ? x + " where " + where : x + "," + qery2(n - 1, fields, registros, where);
    }

    /**
     * CESARS JOSE MANUEL PINEDO OLIVERA Funcion de tipo Void para Actualizar
     * Registros en la base de datos elegida
     *
     * @param tabla ingrese el nombre de la tabla a la que hara el update
     * @param campos ingrese lo campos con una "," separandolos
     * @param registros ingrese un registro por cada campo separando por ","
     * @param where ingrese la condicion, en este caso es necesaria porque un
     * Update se hace a un registro Especifico
     */
    public boolean actualizar(String tabla, String campos, String registros, String where) {
        String[] fields2 = campos.split(",");
        String[] registros2 = registros.split(",");
        String qery = "update " + tabla + " set " + qery2(fields2.length - 1, fields2, registros2, where);
        System.out.println("Query que se ejecuta" + qery);
        boolean res = false;
        try {
            PreparedStatement pstm = conectardb().prepareStatement(qery);
            pstm.execute();
            res = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    /**
     * Cesars Jose Manuel Pinedo Olivera
     *
     * funcion para eliminar un registro Especifico de una tabla en la base de
     * datos
     *
     * @param tabla ingrese el nombre de la tabla de la cual borrara un registro
     * @param where ingrese la condicion en este caso es necesaria si o si
     * @return retorna un boolean (true/false) si se hizo o no el Delete
     */
    public boolean delete(String tabla, String where) {
        boolean res = false;
        String q = "DELETE " + tabla + " WHERE " + where + "";
        try {
            PreparedStatement pstm = conectardb().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    /**
     * Cesars Jose Manuel Pinedo Olivera funcion para borrar todos los registros
     * de una tabla
     *
     * @param table ingrese el nombre de la tabla de la que quiere eliminar
     * registros(tenga en cuenta los AutoIncrement y los Identity) pues estos no
     * cambian su contador
     * @return retorna un boolean para ver si se hizo o no el borrado
     */
    public boolean deletealltable(String table) {
        boolean res = false;
        String q = "DELETE " + table + "";
        try {
            PreparedStatement pstm = conectardb().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    /**
     * Cesars Jose Manuel Pinedo Olivera funcion para ejecucion de un Procedure
     * registrado en la base de datos
     *
     * @param Procedure nombre de el StoreProcedure
     * @param campos aqui van los campos de el procedure (recuerde que la cadena
     * llena apostrofes '' y los numeric no)
     * @return retorna Boolean para saber si se hizo o no la Ejecucion
     */
    public boolean Exec(String Procedure, String campos) {
        boolean res = false;
        String q = "Exec" + Procedure + " " + campos + "";
        try {
            CallableStatement Clls = conectardb().prepareCall(q);
            Clls.execute();
            Clls.close();
            res = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    /**
     * Cesars Jose Manuel Pinedo Olivera funcion de Consulta para llenar un
     * Jtable
     *
     * @param tabla nombre de la tabla a la que se le hara la Consulta
     * @param campos campos que quiere ver y que por defecto se convertiran en
     * el modelo de la tabla
     * @param where condicion si es que hubiese sino hay ingrese -- null
     * @return retorna un DefaultTableModel un Modelo de Tabla por Defecto puede
     * usar el nombre de el Jtable.setmodel(Select_enTables(xx,xx,xx))
     */
    public DefaultTableModel llenartabla(String tabla, String campos, String where) {
        Object[][] ob = select(tabla, campos, where);
        Object[] col = campos.split(",");
        DefaultTableModel modelo = new DefaultTableModel(ob, col);
        return modelo;
    }

    /**
     * Cesars Jose Manuel Pinedo Olivera funcion para llenar JcomboBox
     *
     * @param tabla ingrese el nombre de la tabla Afectada
     * @param campos ingrese el campo que quiere ver en este caso un comboBox se
     * llena solo con una columna
     * @param where ingrese la condicion
     * @return retorna un DefaultComboBoxModel para otorgar items a un combobox
     * con un .setmodel();
     */
    public DefaultComboBoxModel llenarcombo(String tabla, String campos, String where) {
        Object[][] ob = select(tabla, campos, where);

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < ob.length; i++) {
            ComboData cd = new ComboData(Integer.parseInt(ob[i][0].toString().trim() + ""), ob[i][1].toString().trim() + "");
            modelo.addElement(cd);
        }
        return modelo;
    }

    /**
     * funcion para llenar datos de una lista
     *
     * @param tabla nombre de la tabla implicada
     * @param campos nombre de el campo que mostrara
     * @param where condicion si la necesita sino ponga null
     * @return retorna un DefaultListModel para llenar un Jlist con un
     * .setmodel(xxxx);
     */
    public DefaultListModel llenarlista(String tabla, String campos, String where) {
        Object[][] ob = select(tabla, campos, where);
        DefaultListModel lis = new DefaultListModel();
        for (int i = 0; i < ob.length; i++) {
            lis.add(i, ob[i][0]);
        }
        return lis;
    }

    /**
     * funcion para ejecutar query y ejecutarla por lo es un ExecuteQuery asi
     * que se recomienda usar para consultas o view o funciones
     *
     * @param SQL ingrese la query que quiere ejecutar y esta usara por defecto
     * la conexion que tiene en la base de datos
     * @return retorna un ResultSet para que elija usted como usarlo
     */
    public ResultSet EjecutarSQL(String SQL) {
        ResultSet Rs = null;
        try {
            System.out.println("" + SQL);
            Statement Cmd = this.conectardb().createStatement();
            Rs = Cmd.executeQuery(SQL);
            System.out.println("" + Rs.toString());
        } catch (SQLException ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
        return Rs;
    }

    /**
     * funcion para ejecutar una transaccion en este caso un Insert o un Update
     *
     * @param SQL ingrese query que ejecutara un Insert into o un Update
     * @return retorna un int =1; que puede usar como condicion
     */
    public int Ejecutar_transaccion(String SQL) {
        int r = 0;
        try {
            Statement Cmd = Conexion.dbCon.createStatement();
            r = Cmd.executeUpdate(SQL);
            System.out.print(r);
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
        return r;
    }

    public void desconectar() {
        try {
            dbCon.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
