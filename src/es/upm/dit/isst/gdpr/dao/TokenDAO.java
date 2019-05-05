package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;

import es.upm.dit.isst.gdpr.model.Token;

public interface TokenDAO {
  public Token create(Token token);
  public Token read(String id);
  public Collection<Token> readAll();
  public void update(Token token);
  public void delete(Token token);
}