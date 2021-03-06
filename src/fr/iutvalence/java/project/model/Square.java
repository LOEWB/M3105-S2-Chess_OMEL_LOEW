package fr.iutvalence.java.project.model;


public class Square
{
      private final ColorEnum color;

      private AbstractPiece piece;

      public Square(ColorEnum couleur)
      {
            this.color = couleur;
            this.piece = null;
      }

      public ColorEnum getCouleur()
      {
            return this.color;
      }

      public AbstractPiece getPiece()
      {
            return this.piece;
      }

      public AbstractPiece removePiece()
      {
            AbstractPiece piecePrecedente = this.piece;
            this.piece = null;
            return piecePrecedente;
      }

      public void setPiece(AbstractPiece piece)
      {
            this.piece = piece;
      }

      @Override
      public String toString()
      {
            String delimiteurDeCase = "|";
            String apresPiece = "-" + this.color + delimiteurDeCase;
            if (this.piece == null)
            {
                  return delimiteurDeCase + "()" + apresPiece;
            }
            return delimiteurDeCase + this.piece + apresPiece;
      }

}
