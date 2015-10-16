package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


public class Knight extends AbstractPiece
{
      private final int[][] listPosition = { { 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 1, -2 }, { 1, 2 }, { -1, -2 }, { -1, 2 } };

      public Knight(ColorEnum couleur)
      {
            super(couleur);
            this.Piecetype = PieceType.KNIGHT;
            if (couleur == ColorEnum.BLACK)
            {
                  this.PieceName = ListPieces.BLACK_KNIGHT;
            }
            else
            {
                  this.PieceName = ListPieces.WHITE_KNIGHT;
            }
      }

      @Override
      public List<Position> possibleMovements(Position positionDepart)
      {
            List<Position> possibleMovement = new ArrayList<Position>();
            Square positionDeFin;
            Position newPosition;
            int i, j;

            for (int[] direction : listPosition)
            {
                  i = positionDepart.obtenirNumeroDeLigne() + direction[0];
                  j = positionDepart.obtenirNumeroDeColonne() + direction[1];

                  if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                  {
                        positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));

                        if (positionDeFin.getPiece() != null)
                        {
                              if (positionDeFin.getPiece().obtenirCouleur() == this.couleur)
                              {
                                    continue;
                              }
                              possibleMovement.add(newPosition);
                        }
                        else
                        {
                              possibleMovement.add(newPosition);
                        }
                  }
            }
            return possibleMovement;
      }

     
      @Override
      public String toString()
      {
            return "C" + super.toString();
      }

}
