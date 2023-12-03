package DAO;

import DAO.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util extends Conexion {

    public Util() {

    }

    public int idNext(String nombTbl, String nombCamp) {
        int countReg, IM = 0;
        try {
            String sql = "SELECT COUNT(" + nombCamp + ") AS idMax FROM " + nombTbl + "";
            ResultSet result = resultadoSQL(sql);
            if (result.next()) {
                countReg = result.getInt(1);
                result.close();
                if (countReg > 0) {
                    System.out.append("Entrooo IM");
                    try {
                        sql = "SELECT MAX(" + nombCamp + ") AS idMax FROM " + nombTbl + "";

                        ResultSet result1 = resultadoSQL(sql);
                        if (result1.next()) {
                            IM = result1.getInt(1) + 1;
                        }
                        result1.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    IM++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IM;
    }

    public int estados(String whatEver) {
        int x = 0;
        if (whatEver.equals("No Activo")) {
            x = 0;
        }
        if (whatEver.equals("Activo")) {
            x = 1;
        }
        if (whatEver.equals("Anulado")) {
            x = 2;
        }
        if (whatEver.equals("De Baja")) {
            x = 3;
        }
        return x;
        //Reglas
        //Para DISPOSITIVO
        //NO ACTIVO: Cuando no esta asignado a algún area o permanece en almacen informática
        //ACTIVO: Cuando ya está asignado a algún area <> a almacen informática
        //Para PERSONAL
        //NO ACTIVO:
        //ACTIVO:
    }

    public String estados(int whatEver) {
        String cad = "";
        switch (whatEver) {
            case 0:
                cad = "No Activo";
                break;
            case 1:
                cad = "Activo";
                break;
            case 2:
                cad = "Anulado";
                break;
            case 3:
                cad = "De Baja";
                break;
        }
        return cad;
    }

    public boolean repExp(String nombTbl, String nombCamp, String cad) {

        int countReg;
        boolean sw = false;
        try {
            String sql = "SELECT * FROM " + nombTbl + " where " + nombCamp + " = '" + cad + "'";
            ResultSet result = resultadoSQL(sql);
            if (result.next()) {
                countReg = result.getInt(1);
                result.close();
                if (countReg > 0) {
                    sw = true;
                } else {
                    sw = false;
                }
            } else {
                sw = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sw;
    }

    public String cadExp(String nombTbl, String campID, String nomCampBusq, String cad) {
        String cade = "";
        try {
            String sql = "select " + nomCampBusq + " from " + nombTbl + " where " + campID + " = '" + cad + "'";
            ResultSet result = resultadoSQL(sql);
            if (result.next()) {
                cade = result.getString(1);
            } else {
                cade = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cade;
    }

    public int idExp(String nombTbl, String campID, String nomCampBusq, String cad) {
        int id = 0;
        try {
            String sql = "select " + campID + " from " + nombTbl + " where " + nomCampBusq + " = '" + cad + "'";
            ResultSet result = resultadoSQL(sql);
            if (result.next()) {
                id = result.getInt(1);
            } else {
                id = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public String obtenerFecha() {
        String fecha = "";
        String sql = "";

        //sql = "select CONVERT(varchar,getDate(),103) as fecha";
        sql = "select getdate() as fecha";

        try {
            ResultSet resultado = resultadoSQL(sql);
            resultado.next();
            fecha = resultado.getString(1);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        return fecha;
    }

    public int numRows(String sql) {
        String bigSQL = "";
        int nR = 0;
        bigSQL = "SELECT COUNT(*) AS NumReg FROM (" + sql + ") DERIVEDTBL";

        //System.out.println("bigSQL  "+bigSQL);
        try {
            ResultSet resultado = resultadoSQL(bigSQL);
            if (resultado.next()) {
                nR = resultado.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return nR;
    }

    public int idNext2(String nombTbl, String nombCamp, String campFiltro1, int cad1, String campFiltro2, int cad2) {

        int countReg, IM = 0;
        try {
            String sql = "SELECT COUNT(" + nombCamp + ") AS idMax FROM " + nombTbl + " where " + campFiltro1 + " like '%" + cad1 + "%' and ";
            sql = sql + campFiltro2 + " like '%" + cad2 + "%' ";

            ResultSet result = resultadoSQL(sql);
            if (result.next()) {
                countReg = result.getInt(1);
                result.close();
                if (countReg > 0) {
                    System.out.append("Entrooo IM");
                    try {
                        sql = "SELECT MAX(" + nombCamp + ") AS idMax FROM " + nombTbl + " where " + campFiltro1 + " like '%" + cad1 + "%' and ";
                        sql = sql + campFiltro2 + " like '%" + cad2 + "%' ";

                        ResultSet result1 = resultadoSQL(sql);
                        if (result1.next()) {
                            IM = result1.getInt(1) + 1;
                        }
                        result1.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    IM++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return IM;
    }
}
