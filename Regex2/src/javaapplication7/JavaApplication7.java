package javaapplication7;

import java.util.Scanner;


public class JavaApplication7 {

    
    public static void main(String[] args) {
        
        String[] durum = new String[]{"q0","q1","q2","q3","q4","q5","q6","q7","q8","q9"};
        int dSayisi;
        
        Scanner cevap = new Scanner(System.in);
        Scanner cevap2 = new Scanner(System.in);
        
        System.out.println("Mealey Makinesine hoşgeldiniz...!");
        System.out.println("Q:{q0,q1,q2,q3,q4,q5,q6,q7,q8,q9} (max 10 durumlu)"); 
        System.out.print("Kaç durumlu bir makine olsun: "); dSayisi=cevap.nextInt();
        states[] input = new states[dSayisi];
        
        for(int i = 0 ; i < dSayisi ; i++) input[i] = new states();
        
        System.out.println("£: {} Kullanacağınız alfabeyi giriniz");
        System.out.print("Kac elemanli olucak:"); int aSayisi = cevap2.nextInt();
        
        
        for(int i = 0 ;i<aSayisi;i++){
            System.out.print(i+1+".eleman:"); states.alfabe[i] = cevap.next().charAt(0);
        }
        
        for(int i = 1 ; i < dSayisi ; i++) {
            for( int j = 0 ; j < aSayisi ; j++){
                input[i].alfabeState[j] = input[0].alfabeState[i];
            }
        }
        
        System.out.println("Geçiş ve çıktı tablosu Bilgileri siz tarafından organize edilecektir");
        System.out.println("Lutfen durumlari dogru bi sekilde giriniz aksi taktirde makine calismaz..!");
        
        System.out.print("|\t\t\t|");
        for(int i = 0 ; i < aSayisi ; i++) System.out.print("\t\tAfter input\t"+states.alfabe[i]+"\t\t|");
        System.out.print("\n|\tOld State\t|");
        for(int i = 0 ; i < aSayisi ; i++) System.out.print("\tNew State\t|\tOutPut\t\t|");

        for(int i = 0 , y = 0; i < dSayisi ; i++ ) {
            System.out.print("\n|\t"+durum[i]+"\t\t|");
            for(int j = 0 ; j < aSayisi ; j++ , y++){
                System.out.print("\t   x"+(y)+"\t\t|\tx"+(y+=1)+"\t\t|");
            }

        }
        System.out.println("");
        if(dSayisi > 0){
            
            for(int i = 0 , y=0 ; i < dSayisi ; i++){
                
                for(int j = 0 ; j < aSayisi ; j++ , y++){
                    System.out.print("x"+(y)+":"); input[i].alfabeState[j]= cevap.next();
                    System.out.print("x"+(y+=1)+":"); input[i].alfabeOut[j] = cevap2.next();
                    
                }
            }
         
             System.out.print("\n|\t\t\t|");
             for(int i = 0 ; i < aSayisi ; i++) System.out.print("\t\tAfter input\t"+states.alfabe[i]+"\t\t|");
             
             System.out.print("\n|\tOld State\t|");
             for(int i = 0 ; i < aSayisi ; i++) System.out.print("\tNew State\t|\tOutPut\t\t|");

             for(int i = 0 ; i < dSayisi ; i++ ) {
                 
                 System.out.print("\n|\t"+durum[i]+"\t\t|");
                 
                 for(int j = 0 ; j < aSayisi ; j++ ){
                     
                     System.out.print("\t   "+(input[i].alfabeState[j])+"\t\t|\t"+(input[i].alfabeOut[j])+"\t\t|");
                 }

             }
            
            System.out.print("\nifadenizi giriniz (alfabenize göre) \nifade:"); 
            String ifade = cevap2.next();
            int x;
            int state = 0;
            String[] durumlar = new String[ifade.length()]; 
             //Baslangıç statesi otomatik yazdırır
             
            for(int i = 0;i<ifade.length();i++){
                
                for( int j = 0 ; j < aSayisi ; j++){
                       
                    if(ifade.charAt(i) == states.alfabe[j]){
                        
                        for(x = 0 ; x<dSayisi ; x++){
                            
                            if(input[state].alfabeState[j].equals(durum[x])){
                                
                                states.ciktilar[i]=input[state].alfabeOut[j];
                                durumlar[i] = durum[x];
                                state=x;
                                
                                break;
                            }
                        }//for x a
                    }//alfabe kontrol
                    
                    
                }
                    
            }// ifadenin for
            
            System.out.print("Input string/Output :\t"); for(int i = 0; i<ifade.length();i++) System.out.print(ifade.charAt(i)+"/"+states.ciktilar[i]+" ");
            System.out.print("\nNew State\t\t"); for(int i = 0; i<ifade.length();i++) {
                
                System.out.print(durumlar[i]+"  ");
            }
            
        }// if
        else System.out.print("en az 1 olacak şekilde durum girmelisiniz..!");
        
       
    }

}

