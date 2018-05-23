/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author dyvia
 */
public class Barcode {
    private String input;
    private String dateLim;
    private String numLot;

    public Barcode(String input) {
        this.input = input;
    }

    public void setInput(String input) {
        this.input = input;
    }
    
    public String getInput() {
        return input;
    }

    public String getDateLim() {
        return dateLim;
    }

    public String getNumLot() {
        return numLot;
    }
    
    public boolean analyse(){
        if(input.substring(0,3).equals("]C1")){
            return GS1128();
        }
    
        return false;
    }
    public boolean GS1128(){
        int decodage[]= new int[99];
        
        decodage[0]=18;
        decodage[1]=14;
        decodage[2]=14;
        decodage[10]=20;
        decodage[15]=6;
        decodage[17]=6;
        decodage[30]=8;
        decodage[37]=8;
        
        System.out.println("GS1-128");
        int currentPos=3;
        int sizeVal=0;

        while(currentPos<input.length()-1){

            if(input.charAt(currentPos)=='#'){
                currentPos++;
            }

            int id=Integer.parseInt(input.substring(currentPos, currentPos+2));
            currentPos=currentPos+2;
            sizeVal=decodage[id];

            for(int i=0;i<sizeVal;i++){
                if(currentPos+i<input.length()&&input.charAt(currentPos+i)=='#'){
                    sizeVal=i;
                }
                if(currentPos+i==input.length()){
                    sizeVal=i;
                }
            }
            if(id==17){
                dateLim=input.substring(currentPos,currentPos+sizeVal);
            }
            if(id==10){
                numLot=input.substring(currentPos,currentPos+sizeVal);
            }
            currentPos=currentPos+sizeVal;
        }
        return true;
    }
    
}
