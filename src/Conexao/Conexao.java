package Conexao;

import java.sql.*;
import java.util.ArrayList;
import DAO.Dados.AreaDados;

public class Conexao {
    private String url = "jdbc:mysql://localhost:3306/entervista", user = "root", password = "4217"; 
    Connection con = null;
    AreaCon areaCon;

    public Conexao(String cmd, int p, String nome, int tipo) throws SQLException{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            switch (tipo) {
                case 1:
                    //inserir(cmd, con, nome);
                    areaCon = new AreaCon(cmd, con, nome, p);
                    
                    break;
            
                case 2:
                    //selecionar(cmd, con);
                    
                    break;

                case 3:
                    //deletar(cmd, con);
                    break;
                case 4:
                    //editar(cmd, con, nome);
                    break;
            }

            con.close();
        }catch (Exception e){
            System.out.println("Não foi possível completar a conexão: erro de conexão");
        }
    }

    public ArrayList<AreaDados> getAreas(){
        return areaCon.getAreas();
    }
    
}

    