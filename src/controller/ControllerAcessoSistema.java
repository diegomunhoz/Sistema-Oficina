package controller;

import entidade.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import tools.Dao;
import view.frmAcessoSistema;
import view.frmPrincipal;
import view.frmUsuario;


public class ControllerAcessoSistema {

    public ControllerAcessoSistema(frmAcessoSistema viewAcessoSistema) {
        this.viewAcessoSistema = viewAcessoSistema;
        this.listaUsuario = this.dao.pesquisar("Usuario.findAll");
    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private List<Usuario> listaUsuario;
    private frmAcessoSistema viewAcessoSistema;
    private Usuario usuario;

    public void entrar() {

        if (this.viewAcessoSistema.getEdtLogin().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo login é obrigatório!!");
        } else if (this.viewAcessoSistema.getEdtSenha().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo senha é obrigatório!!");
        } else {
            if (this.listaUsuario.isEmpty()) {
                if (this.viewAcessoSistema.getEdtLogin().getText().equals("admin") && this.viewAcessoSistema.getEdtSenha().getText().equals("admin")) {
                    frmUsuario cadastrarUsuario = new frmUsuario();
                    JOptionPane.showMessageDialog(null, "É nescessário cadastrar um usuário para acessar o sistema!!!");
                    cadastrarUsuario.setVisible(true);
                    this.viewAcessoSistema.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou Senha inválidos!!!");
                }
            } else {
                int aux = 0;
                for (Usuario usu : this.listaUsuario) {
                    if (usu.getLogin().equals(this.viewAcessoSistema.getEdtLogin().getText()) && usu.getSenha().equals(this.viewAcessoSistema.getEdtSenha().getText())) {
                        this.usuario = usu;
                        aux = 1;
                        break;
                    }
                }
                if (aux == 1) {
                    frmPrincipal principal = new frmPrincipal();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    principal.getLblData().setText(dateFormat.format(new Date(System.currentTimeMillis())));
                    principal.getLblSaudacao().setText("Usuário: " + this.usuario.getNome().toString());
                    principal.setVisible(true);
                    this.viewAcessoSistema.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou Senha inválidos!!!");
                }
            }
        }
    }
}
