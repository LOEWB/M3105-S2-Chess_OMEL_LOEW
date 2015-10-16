package fr.iutvalence.java.project.model;


import java.util.List;


public abstract class AbstractPiece
{
      protected PieceType Piecetype;

      protected ListPieces PieceName;

      protected final ColorEnum couleur;

      public boolean hasAlreadyMove;

      
      protected AbstractPiece(ColorEnum couleur)
      {
            this.couleur = couleur;
            this.hasAlreadyMove = false;
      }

      public ListPieces getPieceName()
      {
            return this.PieceName;
      }

      public PieceType getPieceType()
      {
            return this.Piecetype;
      }

      public boolean isHasAlreadyMove()
      {
            return hasAlreadyMove;
      }

      public void itDidntMoved()
      {
            this.hasAlreadyMove = false;
      }
      
      public void itMoved()
      {
            this.hasAlreadyMove = true;
      }

      public ColorEnum obtenirCouleur()
      {
            return this.couleur;
      }

      public abstract List<Position> possibleMovements(Position positionDepart);

      @Override
      public String toString()
      {
            return this.couleur.toString();
      }
}