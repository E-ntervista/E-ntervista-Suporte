package Conexao;

import java.sql.*;
import java.util.ArrayList;
import DAO.Dados.AreaDados;


public class AreaCon extends GetData{
    private String cmd, nome;
    private Connection con;
    private ArrayList<AreaDados> areas = new ArrayList<>();

    public AreaCon(String cmd, Connection con, String nome, int p){

        this.cmd = cmd;
        this.nome = nome;
        this.con = con;
        
        switch (p) {
            case 1:
                inserir();
                break;
        
            case 2:
                selecionar();
                break;
        }
    }

    public void inserir(){
        try{
            PreparedStatement stmt = con.prepareStatement(cmd);
            stmt.setString(1, nome);
            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void selecionar(){
        try {
            areas = new ArrayList<>();

            PreparedStatement stmt = con.prepareStatement(cmd);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                AreaDados area = new AreaDados(rs.getInt(1), rs.getString(2));
                areas.add(area);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
    public void deletar(){
        try{
            //PreparedStatement stmt = con.prepareStatement(cmd);
            //stmt.setString(1, nome);
            //stmt.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void editar(){
        try{
            PreparedStatement stmt = con.prepareStatement(cmd);
            stmt.setString(1, nome);
            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }
    }
    */

    public void setAreas(){
        super.areas = this.areas;
    }

    public ArrayList<AreaDados> getAreas(){
        return super.getAreas();
    }
}
