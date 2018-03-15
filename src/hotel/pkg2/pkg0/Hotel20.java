package hotel.pkg2.pkg0;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Hotel20 {
    public static void main(String[] args) {
        String cuartos[][];
        cuartos= new String[10][5];
        int piso,cuarto,salto,opcion,tiempo;
        String letra,salida,cual;
        letra="";
        JTextArea hoja;
        boolean existe,estalibre;
        double costo,caja,precio;
        for(piso=0;piso<5;piso++){
            switch(piso){
                case 0:
                    letra="A"; break;
                case 1:
                    letra="B"; break; 
               case 2:
                    letra="C"; break;
               case 3:
                    letra="D"; break;
               case 4:
                    letra="E"; break;
               default: break;     
            }
            salto=1;
            for(cuarto=0;cuarto<10;cuarto=cuarto+2){
                cuartos[cuarto][piso]=letra+salto;
                salto=salto+1;
            }
        }
        for(piso=0;piso<5;piso++){
            for(cuarto=0;cuarto<10;cuarto++){
               if((cuartos[cuarto][piso])==null){
                   cuartos[cuarto][piso]="☺";
               }
            }
        }
        caja=0;
        do{
            tiempo=0;
            costo=0;
            existe=false;
            estalibre=false;
            salida="ESTADO DE LAS HABITACIONES (☺=disponible,☻=ocupado)\n";
            hoja= new JTextArea();
        opcion=Integer.parseInt(JOptionPane.showInputDialog("Menú\n1.Ver estado de las habitaciones\n2.Alquilar habitacion\n3.Devolver habitacion\n4.Revisar la caja\n0.Cerrar hotel")); 
        switch(opcion){
            case 1:{
                for(piso=0;piso<5;piso++){
                 for(cuarto=0;cuarto<10;cuarto++){
                  salida=salida+cuartos[cuarto][piso]+"\t";
                  }
                  salida=salida+"\n";
                  }
                   hoja.setText(salida);
                   JOptionPane.showMessageDialog(null,hoja);
                   break;
                 }
            case 2:{
                cual=JOptionPane.showInputDialog("¿Cual habitacion desea?");
                for(piso=0;piso<5;piso++){
                 for(cuarto=0;cuarto<10;cuarto++){
                    if((cuartos[cuarto][piso]).equals(cual)){
                   existe=true;
                   if(cuartos[cuarto+1][piso].equals("☺")){
                       estalibre=true;
                       do{
                       tiempo=Integer.parseInt(JOptionPane.showInputDialog("¿Por cuantos dias va a reservar? (20$ cada dia)"));
                       }while(tiempo<=0);
                       cuartos[cuarto+1][piso]="☻";
                   }
               }
               }
               }
               if(existe==true){
                   if(estalibre==true){
                       costo=tiempo*20;
                       JOptionPane.showMessageDialog(null,"Ha reservado la hibitación "+cual+" por "+tiempo+" dias\nTotal a pagar: "+costo+"$");
                       caja=caja+costo;
                   }
                   else{
                       JOptionPane.showMessageDialog(null,"La habitación "+cual+" ya está ocupada");
                   }
               }
               else{
                   JOptionPane.showMessageDialog(null,"La habitación "+cual+" no existe");
               }
               break;
            }
            case 3:{
                cual=JOptionPane.showInputDialog("¿Cual habitacion va a devolver?");
                for(piso=0;piso<5;piso++){
                 for(cuarto=0;cuarto<10;cuarto++){
                    if((cuartos[cuarto][piso]).equals(cual)){
                   existe=true;
                   if(cuartos[cuarto+1][piso].equals("☻")){
                       estalibre=true;
                       cuartos[cuarto+1][piso]="☺";
                   }
               }
               }
               }
               if(existe==true){
                   if(estalibre==true){
                       JOptionPane.showMessageDialog(null,"Devolucion exitosa de la habitación "+cual);
                   }
                   else{
                       JOptionPane.showMessageDialog(null,"La habitacion "+cual+" no estaba ocupada");
                   }
               }
               else{
                   JOptionPane.showMessageDialog(null,"La habitación "+cual+" no existe");
               }
               break;
            }
            case 4:{
                JOptionPane.showMessageDialog(null,"Total actual en caja: "+caja+"$");
                break;
            }
        }
        }while(opcion!=0);
      JOptionPane.showMessageDialog(null,"Total en caja: "+caja+"$");  
    }
}
