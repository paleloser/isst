package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;
import java.util.UUID;

import org.hibernate.Session;

import es.upm.dit.isst.gdpr.model.Token;

public class TokenDAOImplementation implements TokenDAO {

  private static TokenDAOImplementation instancia = null;

  public static TokenDAOImplementation getInstance() {
    if (instancia == null)
      instancia = new TokenDAOImplementation();
    return instancia;
  }

  private TokenDAOImplementation() {
  }

  @Override
  public Token create(Token token) {

    Session session = SessionFactoryService.get().openSession();
    try {
      session.beginTransaction();
      String id = UUID.randomUUID().toString();
      token.setValido(true);
      token.setId(id);
      session.save(token);
      session.getTransaction().commit();
      return token;
    } catch (Exception e) {
      System.out.print(e);
    } finally {
      session.close();
    }
    return null;
  }

  @Override
  public Token read(String id) {

    Session session = SessionFactoryService.get().openSession();
    Token token = null;
    try {

      session.beginTransaction();
      token = session.load(Token.class, id);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }

    return token;
  }

  @Override
  public void update(Token token) {

    Session session = SessionFactoryService.get().openSession();
    try {

      session.beginTransaction();
      session.saveOrUpdate(token);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }

  }

  @Override
  public void delete(Token token) {

    Session session = SessionFactoryService.get().openSession();
    try {

      session.beginTransaction();
      session.delete(token);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }
  }

  @Override
  public Collection<Token> readAll() {

    Session session = SessionFactoryService.get().openSession();
    Collection<Token> tokens = null;
    try {

      session.beginTransaction();
      tokens = session.createQuery("from Token").list();
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.print(e);

    } finally {

      session.close();
    }
    return tokens;
  }

}
