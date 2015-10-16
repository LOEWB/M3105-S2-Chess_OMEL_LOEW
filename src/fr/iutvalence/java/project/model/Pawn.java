package fr.iutvalence.java.project.model;


import java.util.ArrayList;
import java.util.List;


public class Pawn extends AbstractPiece
{
      private final int[][] listPosition = { { 1, 0 } };

      private final int[][] listPosition2 = { { 1, 1 }, { 1, -1 } };

      public Pawn(ColorEnum couleur)
      {
            super(couleur);
            this.Piecetype = PieceType.PAWN;
            if (couleur == ColorEnum.BLACK)
            {
                  this.PieceName = ListPieces.BLACK_PAWN;
            }
            else
            {
                  this.PieceName = ListPieces.WHITE_PAWN;
            }
      }

      @Override
      public List<Position> possibleMovements(Position positionDepart)
      {
            List<Position> possibleMovement = new ArrayList<Position>();
            Square positionDeFin;
            Square positionDeFin2;
            Position newPosition;
            int i, j;
            for (int[] direction : listPosition)
            {
                  if (this.couleur == ColorEnum.BLACK)
                  {
                        i = positionDepart.obtenirNumeroDeLigne() + direction[0];
                  }
                  else
                  {
                        i = positionDepart.obtenirNumeroDeLigne() - direction[0];
                  }
                  j = positionDepart.obtenirNumeroDeColonne() + direction[1];
                  if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                  {
                        positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                        if (positionDeFin.getPiece() != null)
                        {
                              break;
                        }
                        else
                        {
                              possibleMovement.add(newPosition);
                              if (this.couleur == ColorEnum.BLACK)
                              {
                                    i = positionDepart.obtenirNumeroDeLigne() + 2;
                              }
                              else
                              {
                                    i = positionDepart.obtenirNumeroDeLigne() - 2;
                              }
                              if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES)
                              {
                                    positionDeFin2 = Echiquier.square.get(newPosition = new Position(i, j));
                                    if (!this.hasAlreadyMove && positionDeFin2.getPiece() == null)
                                    {
                                          possibleMovement.add(newPosition);
                                    }
                              }
                        }
                  }
            }
            for (int[] direction2 : listPosition2)
            {
                  if (this.couleur == ColorEnum.BLACK)
                  {
                        i = positionDepart.obtenirNumeroDeLigne() + direction2[0];
                  }
                  else
                  {
                        i = positionDepart.obtenirNumeroDeLigne() - direction2[0];
                  }
                  j = positionDepart.obtenirNumeroDeColonne() + direction2[1];
                  if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                  {
                        positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                        if (positionDeFin.getPiece() == null)
                        {
                              continue;
                        }
                        else
                        {
                              if (positionDeFin.getPiece().obtenirCouleur() != this.couleur)
                              {
                                    possibleMovement.add(newPosition);
                              }
                        }
                  }
            }
            return possibleMovement;
      }

      @Override
      public String toString()
      {
            return "P" + super.toString();
      }

}
