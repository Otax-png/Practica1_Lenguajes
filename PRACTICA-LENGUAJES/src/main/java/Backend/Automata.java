package Backend;



public class Automata {
    int contador;
    char [] caracter;
    String lexema;
    

    
    
    
    public Automata(String texto){
        caracter = texto.toCharArray();        
    }
    
    public void inicio(){    
        contador = 0;
        Estado0();
    }
    
    
    public void Estado0(){
        lexema = "";
        if(contador<caracter.length){
                //agregando texto
            if(caracter[contador] >= 65 && caracter[contador] <= 90 || caracter[contador] >= 48 && caracter[contador] <= 57){
                lexema = lexema + caracter[contador];
                contador++;
                Estado1();
                //agregando digito
            } else if(caracter[contador] >= 48 && caracter[contador] <= 57){
                lexema = lexema + caracter[contador];
                contador++;
                Estado2();
                //agregando puntuacion
            } else if(caracter[contador] == 46 || caracter[contador] == 44 || caracter[contador] >= 58 && caracter[contador] <= 59){
                lexema = lexema + caracter[contador];
                contador++;
                Estado4();
                //agregando operador
            } else if(caracter[contador] == 43 || caracter[contador] == 45 || caracter[contador] == 47 || caracter[contador] == 42 || caracter[contador] == 37 || caracter[contador] == 246){
                lexema = lexema + caracter[contador];
                contador++;
                Estado5();
                //agregando agrupacion
            } else if(caracter[contador] >= 40 && caracter[contador] <= 41 || caracter[contador] == 91 || caracter[contador] == 93 || caracter[contador] == 123 || caracter[contador] == 125){
                lexema = lexema + caracter[contador];
                contador++;
                Estado6();
            } else if(caracter[contador] == ' ' || caracter[contador] == '\n'|| caracter[contador] == '\t'){
                contador++;
                Estado0();
            } else{
                lexema = lexema + caracter[contador];
                error();
            }
        }
    }
    
    
    //PARTE TEXTO
    public void Estado1(){
        if(contador<caracter.length){
            if(caracter[contador] >= 65 && caracter[contador] <= 90 || caracter[contador] >= 97 && caracter[contador] <= 122){
                lexema = lexema + caracter[contador];
                contador++;
                Estado1();
                //agregando digito
            } else if(caracter[contador] >= 48 && caracter[contador] <= 57){
                lexema = lexema + caracter[contador];
                contador++;
                Estado1();
            } else if(caracter[contador] == ' ' || caracter[contador] == '\n'|| caracter[contador] == '\t'){
                succesful(1);
            } else {
                lexema = lexema + caracter[contador];
                error();
            }
        }
    }
    
    //PARTE DIGITO
    public void Estado2(){
         if(contador<caracter.length){
            if(caracter[contador] >= 48 && caracter[contador] <= 57){
                lexema = lexema + caracter[contador];
                contador++;
                Estado2();
                
            }  else if(caracter[contador] == '.'){
                lexema = lexema + caracter[contador];
                contador++;
                Estado3();
                
            }  else if(caracter[contador] == ' ' || caracter[contador] == '\n'|| caracter[contador] == '\t'){
                succesful(2);
            } else {
                error();
            }
            
         } 
         
    }   
    
    public void Estado3(){
        if(contador<caracter.length){
            if(caracter[contador] >= 48 && caracter[contador] <= 57){
                lexema = lexema + caracter[contador];
                contador++;
                Estado3();                
            }  else if(caracter[contador] == ' ' || caracter[contador] == '\n'|| caracter[contador] == '\t'){
                succesful(6);               
            } else {
                error();
            }
        }
    }
    
    //PARTE PUNTUACION
    public void Estado4(){
        if(contador<caracter.length){
            if(caracter[contador] == 46 || caracter[contador] == 44 || caracter[contador] >= 58 && caracter[contador] <= 59){
                lexema = lexema + caracter[contador];
                contador++;
                Estado4();               
            }  else if(caracter[contador] == ' ' || caracter[contador] == '\n'|| caracter[contador] == '\t'){
                succesful(3);
            } else {
                error();
            }
        }
    }
    
    //PARTE OPERADOR
    public void Estado5(){
        if(contador<caracter.length){
             if(caracter[contador] == 43 || caracter[contador] == 45 || caracter[contador] == 47 || caracter[contador] == 42 || caracter[contador] == 37 || caracter[contador] == 246){
                lexema = lexema + caracter[contador];
                contador++;
                Estado5();                
            }  else if(caracter[contador] == ' ' || caracter[contador] == '\n'|| caracter[contador] == '\t'){
                succesful(4);
            } else {
                error();
            }
        }
    }
    
    //PARTE AGRUPADOR
    public void Estado6(){
        if(contador<caracter.length){
            if(caracter[contador] >= 40 && caracter[contador] <= 41 || caracter[contador] == 91 || caracter[contador] == 93 || caracter[contador] == 123 || caracter[contador] == 125){
                lexema = lexema + caracter[contador];
                contador++;
                Estado6();              
            }  else if(caracter[contador] == ' ' || caracter[contador] == '\n'|| caracter[contador] == '\t'){
                succesful(5);
            } else {
                error();
            }
        }
    }
    
    public void succesful(int test ){
        switch(test){
            case 1:
                ArregloTokens.Tokens.add(new Token("Identificador",lexema,contador));
                break;
            case 2:
                ArregloTokens.Tokens.add(new Token("Numero",lexema,contador));
                break;
            case 3:
                ArregloTokens.Tokens.add(new Token("Puntuacion",lexema,contador));
                break;
            case 4:
                ArregloTokens.Tokens.add(new Token("Operador",lexema,contador));
                break;
            case 5:
                ArregloTokens.Tokens.add(new Token("Agrupacion",lexema,contador));
                break;
            case 6:
                ArregloTokens.Tokens.add(new Token("Decimal",lexema,contador));
                break;  
        }
        contador++;
        Estado0();
        
    }
    
    
    public void error(){
        ArregloTokens.Errores.add(new Token("Error",lexema,contador));
        contador++;
        Estado0();
    }
}
