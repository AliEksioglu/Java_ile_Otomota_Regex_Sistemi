package javaapplication6;

import java.util.Scanner;


public class JavaApplication6 {

    
    public static void main(String[] args) {
        
        String[] durum = new String[]{"q0","q1","q2","q3","q4","q5","q6","q7","q8","q9"};
        int dSayisi;
        
        Scanner cevap = new Scanner(System.in);
        Scanner cevap2 = new Scanner(System.in);
        
        System.out.println("Moore Makinesine hoşgeldiniz...!");
        System.out.println("Q:{q0,q1,q2,q3,q4,q5,q6,q7,q8,q9} (max 10 durumlu)"); 
        System.out.print("Kaç durumlu bir makine olsun: "); dSayisi=cevap.nextInt();
        states[] input = new states[dSayisi];
        
        if(dSayisi > 0){
        
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
            System.out.println("Lutfen durumlari dogru bi sekilde giriniz aksi taktirde makine calismaz..!( q1 q2 ) olarak giriniz)");
            
            System.out.print("Old State\t|\t");
            for(int i = 0 ; i < aSayisi ; i++)  System.out.print(" After input "+states.alfabe[i]+"\t\t");
            System.out.println("\t|\tCharecter printed");

            for(int i = 0 , y=-1; i < dSayisi ; i++ ){
                System.out.print("  "+durum[i]+"\t\t|\t\t");
                
                for(int j = 0 ; j < aSayisi ; j++ ){
                    
                    System.out.print("x"+(y+=1)+"\t\t\t");

                }
                System.out.println("|\t\tx"+(y+=1));
            }
            
            //burda x değerlerini almaya başlıyourm
            
            System.out.println("");
            
            for(int i = 0 , y=-1 ; i < dSayisi ; i++){
                
                for(int j = 0 ; j < aSayisi ; j++ ){
                    System.out.print("x"+(y+=1)+":"); input[i].alfabeState[j]= cevap.next();
                }
                System.out.print("x"+(y+=1)+":"); input[i].alfabeOut = cevap2.next();
            }
            
            //Alınan değerlere göre tabloyu yazdırıyorum
            
            System.out.print("\nOld State\t|\t");
            for(int i = 0 ; i < aSayisi ; i++)  System.out.print(" After input "+states.alfabe[i]+"\t\t");
            System.out.println("\t|\tCharecter printed\t|");

            
            for(int i = 0 ; i < dSayisi ; i++ ){
                
                System.out.print("  "+durum[i]+"\t\t|\t\t");
                
                for(int j = 0 ; j < aSayisi ; j++ ){
                    
                    System.out.print(""+(input[i].alfabeState[j])+"\t\t\t");

                }
                System.out.println("|\t\t"+(input[i].alfabeOut)+"\t\t|");
            }
            

            System.out.print("\nifadenizi giriniz (alfabenizdeki harflere göre)\nifade:"); 
            String ifade = cevap2.next();
            int x;
            int state = 0;
            String[] durumlar = new String[ifade.length()+1]; 
             //Baslangıç statesi otomatik yazdırır
      
            for(int i = 0;i<ifade.length();i++){
                
                if(i==0){
                    states.ciktilar[0] = input[0].alfabeOut;
                    durumlar[i]=durum[0];
                    }  
                    for( int j = 0 ; j < aSayisi ; j++){
                        if(ifade.charAt(i) == states.alfabe[j]){
                            for(x = 0 ; x<dSayisi ; x++){
                                if(input[state].alfabeState[j].equals(durum[x])){
                                    state=x;
                                    durumlar[i+1] = durum[state];
                                    states.ciktilar[i+1]=input[state].alfabeOut;
                                    break;
                                }
                            }//for x a
                        }//a kontrolu
                    }// j for
                        
            }// ifadenin for
            
            System.out.print("Input string:\t    "); for(int i = 0; i<ifade.length();i++) System.out.print(ifade.charAt(i)+"   ");
            System.out.print("\nState\t\t"); for(int i = 0; i<ifade.length()+1;i++) {
                
                System.out.print(durumlar[i]+"  ");
            }
            
            System.out.print("\nOutput\t\t"); for(int i = 0; i<ifade.length()+1;i++) System.out.print(states.ciktilar[i]+"   ");
            
          
        }// if
        else System.out.print("en az 1 olacak şekilde durum girmelisiniz..!");
     
        
    }

}

