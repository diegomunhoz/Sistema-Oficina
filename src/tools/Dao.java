package tools;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.Parameter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.exceptions.DatabaseException;

public class Dao {

    private String nameOfPU;

    /*
     * Construtor para que possa saber qual base de dados deve ser acessado
     * @param objeto: nome da Unidade de Percistência
     */
    public Dao(String namePU) {
        this.nameOfPU = namePU;
    }

    /**
     * O método gravar (Object objeto) recebe o objeto a ser persistido e retorna uma
     * mensagem caso a transação seja realizada com sucesso ou não
     * @param objeto: O objeto que se deseja persistir
     */
    public String gravar(Object objeto) {
        EntityManager entityManager = getEntityManager();
        String mensagem = "";
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            mensagem = "Registro persistido com sucesso";
        } catch (Exception exception) {
            System.out.print(exception.getCause());
            mensagem = "Erro durante a gravação";
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            return mensagem;
        }
    }

    /**
     * O metodo excluir (Object objeto) recebe o objeto a ser excluído do banco de dados e
     * retorna uma mensagem caso a transação seja realizada com sucesso ou não
     * @param objeto: O objeto que se deseja excluir
     */
    public String excluir(Object objeto) {
        EntityManager entityManager = getEntityManager();
        String mensagem = "";
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(objeto));
            entityManager.flush();
            entityManager.getTransaction().commit();
            mensagem = "Exclusão realizada com suceso!";
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            if (exception.getCause().getClass() == DatabaseException.class) {
                DatabaseException databaseException = (DatabaseException) exception.getCause();
                mensagem = "Falha durante a exclusão";
                if (databaseException.getDatabaseErrorCode() == 1451) {
                    mensagem = "1451";
                }
            } else {
                mensagem = "Falha durante a exclusão!";
            }
        } finally {
            entityManager.close();
            return mensagem;
        }
    }

    /**
     * O método pesquisar(String namedQuery, Object[] objeto)
     * exige que o programador envie o nome da named query e
     * um ou mais parâmetros para executar a busca.
     * @param namedQuery: Query que se deseja executar.
     * @param object[]: Array de parametros da namedQuery.
     */
    public List pesquisar(String nomeQuery, Object[] objeto) {
        EntityManager entityManager = getEntityManager();
        int i = 0;
        Query query = entityManager.createNamedQuery(nomeQuery);
        for (Parameter parametro : query.getParameters()) {
            query.setParameter(parametro, objeto[i++]);
        }
        return query.getResultList();
    }

    /**
     * O método pesquisaar(String namedQuery)
     * devolve uma lista de objetos através de uma
     * named query sem parâmetros
     * @param namedQuery: Query que se deseja executar.
     */
    public List pesquisar(String namedQuery) {
        EntityManager entityManager = getEntityManager();
        return entityManager.createNamedQuery(namedQuery).getResultList();
    }

    /**
     * O método getEntityManager()
     * resposável para fazer a conexão com a base de dados para realizar
     * consultas e persistência
     */
    private EntityManager getEntityManager() {
        EntityManager entityManager;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(this.nameOfPU);
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}