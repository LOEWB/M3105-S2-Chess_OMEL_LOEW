package fr.iutvalence.java.project.chessgame;


import java.util.List;


public abstract class AbstractPiece
{
      protected PieceType Piecetype;

      protected ListPieces PieceName;

      protected final ColorEnum couleur;

      /**
       * Default : 0 when it hasn't moved yet, 1 when it already moved
       */
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

      /**
       * Détermine les différents movements possible à partir d'une position de
       * départ donnée
       *
       * @param positionDepart La position actuelle de la pièce
       * @return Une liste de tout les déplacements possible à partir d'une
       *         position
       */
      public abstract List<Position> possibleMovements(Position positionDepart);

      @Override
      public String toString()
      {
            return this.couleur.toString();
      }
}