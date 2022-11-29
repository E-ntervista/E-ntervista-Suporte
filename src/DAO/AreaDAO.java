package DAO;

import java.util.ArrayList;
import DAO.Dados.AreaDados;
import Conexao.Conexao;

public class AreaDAO{
    private String nome;
    private Conexao con;

    public AreaDAO(String nome, int p) {
        this.nome = nome;

        try{
            con = new Conexao(criarComando(p), p, nome, 1);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public String criarComando(int p) {
        String cmd = null;

        if (p == 1) {
            cmd = "insert into area (nome) values (?);";
        } else if(p == 2) {
            cmd = "select * from area;";
        }

        return cmd;
    }

    public String criarComando(int p, int id) {
        String cmd = null;

        if (p == 3) {
            cmd = "delete from area where id = ?";
        } else if(p == 4){
            cmd = "update area set nome = ? where id = ?";
        }

        return cmd;
    }

    public ArrayList<AreaDados> getAreas(){
        return con.getAreas();
    }
}
