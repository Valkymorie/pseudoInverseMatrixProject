/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab;

/**
 *
 * @author EMİR
 */
public class islemler {

        int toplamaSayac=0;
        int carpmaSayac=0;
        int cikarmaSayac=0;
        int bolmeSayac=0;
    public float[][] tersAlma(float[][] matris, int sat, int sut) {

        float[][] islemMatris = new float[sat][sut];
        float[][] tersMatris = new float[sat][sut];
        float tutamac1, tutamac2;

        for (int i = 0; i < sat; i++) {
            for (int j = 0; j < sut; j++) {
                islemMatris[i][j] = matris[i][j];
            }
        }

        for (int i = 0; i < sat; i++) { // BİRİM MATRİS
            for (int j = 0; j < sut; j++) {
                if (i == j) {
                    tersMatris[i][j] = (float) 1;
                } else {
                    tersMatris[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < sat; i++) {
            tutamac1 = islemMatris[i][i];
            for (int j = 0; j < sat; j++) {
                islemMatris[i][j] = islemMatris[i][j] / tutamac1;
                bolmeSayac++;
                tersMatris[i][j] = tersMatris[i][j] / tutamac1;
                bolmeSayac++;
            }
            for (int k = 0; k < sat; k++) {
                if (k != i) {
                    tutamac2 = islemMatris[k][i];
                    for (int z = 0; z < sat; z++) {
                        islemMatris[k][z] = islemMatris[k][z] - (islemMatris[i][z] * tutamac2);
                        cikarmaSayac++;
                        carpmaSayac++;
                        tersMatris[k][z] = tersMatris[k][z] - (tersMatris[i][z] * tutamac2);
                        cikarmaSayac++;
                        carpmaSayac++;
                    }
                }
            }

        }

        return tersMatris;
    }

    public float[][] carmaIslemi(float[][] ilkMatris, int ilkSat, int ilkSut, float[][] sonMatris, int sonSat, int sonSut) {
        float[][] carpimMatris = new float[ilkSat][sonSut];

        for (int i = 0; i < ilkSat; i++) {
            for (int j = 0; j < sonSut; j++) {
                carpimMatris[i][j] = 0;
            }

        }

        for (int i = 0; i < ilkSat; i++) {
            for (int j = 0; j < sonSut; j++) {
                for (int k = 0; k < ilkSut; k++) {
                    carpimMatris[i][j] += ilkMatris[i][k] * sonMatris[k][j];
                    toplamaSayac++;
                    carpmaSayac++;
                }
            }
        }
        return carpimMatris;
    }

    public float[][] transpozeAl(float matris[][], int sat, int sut) {

        float[][] transpoze = new float[sut][sat];

        for (int i = 0; i < sat; i++) {
            for (int j = 0; j < sut; j++) {
                transpoze[j][i] = matris[i][j];
            }
        }
        return transpoze;
    }

    public int toplamaSayisiDondur(){
        
        return toplamaSayac;
    }
    
    public int carpmaSayisiDondur(){
        
        return carpmaSayac;
    }
    public int cikarmaSayisiDondur(){
        
        return cikarmaSayac;
    }
    public int bolmeSayisiDondur(){
        
        return bolmeSayac;
    }
    
}
