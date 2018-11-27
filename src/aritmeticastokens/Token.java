package aritmeticastokens;

// se importa la librería ArrayList
import java.util.ArrayList;

public class Token {
    
    // se crean las variables a utilizar
    // los int indican el numero del token
    // los arraylist almacen el tipo y valor del respectivo token
    private int numIDE, numOA, numOR, numOB, numCE, numCF, numELX, numPR, numEST;
    private ArrayList<String> tokenOA, valorOA, tokenOR, valorOR, tokenOB, valorOB, tokenCE, valorCE, tokenCF, valorCF, tokenTodo, valorTodo, tokenELX, valorELX, tokenPR, valorPR, tokenEST, valorEST;
    private ArrayList<String[]> tokenIDE, valorIDE;
    
    // se inicializa todo en el constructor
    public Token() {
        tokenIDE = new ArrayList<>();
        tokenOA = new ArrayList<>();
        tokenOR = new ArrayList<>();
        tokenOB = new ArrayList<>();
        tokenCE = new ArrayList<>();
        tokenCF = new ArrayList<>();
        tokenELX = new ArrayList<>();
        tokenPR = new ArrayList<>();
        tokenEST = new ArrayList<>();
        tokenTodo = new ArrayList<>();
        valorIDE = new ArrayList<>();
        valorOA = new ArrayList<>();
        valorOR = new ArrayList<>();
        valorOB = new ArrayList<>();
        valorCE = new ArrayList<>();
        valorCF = new ArrayList<>();
        valorELX = new ArrayList<>();
        valorPR = new ArrayList<>();
        valorEST = new ArrayList<>();
        valorTodo = new ArrayList<>();
        numIDE = 1;
        numOA = 1;
        numOR = 1;
        numOB = 1;
        numCE = 1;
        numCF = 1;
        numELX = 1;
        numPR = 1;
        numEST = 1;
    }
    
    public int buscarIDE (String token) {
        int apun;
        
        for (apun = 0; apun < tokenIDE.size(); apun++) {
            
            if (token.equals(tokenIDE.get(apun)[1])) {
                break;
            }
            
        }
        
        return apun;
    }
    
    public int buscarPR (String token) {
        int apun;
        
        for (apun = 0; apun < tokenPR.size(); apun++) {
            
            if (token.equals(tokenPR.get(apun))) {
                break;
            }
            
        }
        
        return apun;
    }
    
    public int buscarOA (String token) {
        int apun;
        
        for (apun = 0; apun < tokenOA.size(); apun++) {
            
            if (token.equals(tokenOA.get(apun))) {
                break;
            }
            
        }
        
        return apun;
    }
    
    public void setIDE(String valor, String tipo) {
        
        // arreglo para guardar el identificador y el tipo
        String[] IDE = new String[2];
        String[] valIDE = new String[2];
        
        // indicador de que el token no existe
        boolean aux = true;
        
        // indicador auxiliar para escribir el token que ya existe
        int apunAux = 0;
        
        // si hay mas de un token registrado
        if(numIDE > 1) {
            
            // se analiza si el token se ha registrado antes
            for (int i = 0; i < valorIDE.size(); i++) {
                
                if (valorIDE.get(i)[1].equals(valor)) {
                    
                    // al encontrarse el token, el indicador cambia a false por que el token si existe
                    // y en el otro indicador se guarda cual numero de token es
                    aux = false;
                    apunAux = i;
                }
            }
            
            // despues de analizar, si el token no existe se registra el nuevo token
            if (aux) {
                
                // primero en el ArrayList especifico del token
                IDE[0] = tipo;
                IDE[1] = "IDE" +numIDE;
                valIDE[0] = "null";
                valIDE[1] = valor;
                tokenIDE.add(IDE);
                valorIDE.add(valIDE);
                
                // despues en el ArrayList donde se escriben todos los tokens
                tokenTodo.add("IDE" +numIDE);
                valorTodo.add(valor);
                
                // se aumenta el numero de Tokens registrados.
                numIDE++;
            }
            
            // si el token existe
            else {
                // se obtiene el token existente
                IDE = tokenIDE.get(apunAux);
                valIDE = valorIDE.get(apunAux);
                
                // se revisa si anteriormente era null y se le asigna su nuevo tipo
                if (IDE[0].equals("null")) {
                    IDE[0] = tipo;
                    tokenIDE.set(apunAux, IDE);
                }
                
                // se registra el token en el ArrayList donde se escriben todos los tokens
                
                tokenTodo.add(IDE[1]);
                valorTodo.add(valIDE[1]);
            }
        }
        
        // si es el primer token de su tipo
        else {
            
            // primero en el ArrayList especifico del token
            IDE[0] = tipo;
            IDE[1] = "IDE" +numIDE;
            valIDE[0] = "null";
            valIDE[1] = valor;
            tokenIDE.add(IDE);
            valorIDE.add(valIDE);
            
            // despues en el ArrayList donde se escriben todos los tokens
            tokenTodo.add("IDE" +numIDE);
            valorTodo.add(valor);
            
            // se aumenta el numero de Tokens registrados.
            numIDE++;
        }
    }
    
    // metodo para actualizar el valor que contienen los ids
    public void actualizarIDE (int apun, String valor) {
        String[] nuevoIDE = valorIDE.get(apun);
        nuevoIDE[0] = valor;
        valorIDE.set(apun, nuevoIDE);
        
        /*
        for (int i = 0; i < tokenTodo.size(); i++) {
            
            if (tokenTodo.get(i).equals(tokenIDE.get(apun)[1])) {
                valorTodo.set(apun, valor);
            }
        }
        */
    }
    
    // metodo para guardar un operador aritmetico
    public void setOA(String valor) {
        
        // indicador de que el token no existe
        boolean aux = true;
        
        // indicador auxiliar para escribir el token que ya existe
        int apunAux = 0;
        
        // si hay mas de un token registrado
        if(numOA > 1) {
            
            // se analiza si el token se ha registrado antes
            for (int i = 0; i < valorOA.size(); i++) {
                
                if (valorOA.get(i).equals(valor)) {
                    
                    // al encontrarse el token, el indicador cambia a false por que el token si existe
                    // y en el otro indicador se guarda cual numero de token es
                    aux = false;
                    apunAux = i;
                }
            }
            
            // despues de analizar, si el token no existe se registra el nuevo token
            if (aux) {
                
                // primero en el ArrayList especifico del token
                tokenOA.add("OA" +numOA);
                valorOA.add(valor);
                
                // despues en el ArrayList donde se escriben todos los tokens
                tokenTodo.add("OA" +numOA);
                valorTodo.add(valor);
                
                // se aumenta el numero de Tokens registrados.
                numOA++;
            }
            
            // si el token existe
            else {
                
                // se registra el token en el ArrayList donde se escriben todos los tokens
                tokenTodo.add(tokenOA.get(apunAux));
                valorTodo.add(valorOA.get(apunAux));
            }
        }
        
        // si es el primer token de su tipo
        else {
            
            // primero en el ArrayList especifico del token
            tokenOA.add("OA" +numOA);
            valorOA.add(valor);
            
            // despues en el ArrayList donde se escriben todos los tokens
            tokenTodo.add("OA" +numOA);
            valorTodo.add(valor);
            
            // se aumenta el numero de Tokens registrados.
            numOA++;
        }
    }
    
    // metodo para guardar un operador aritmetico
    public void setOR(String valor) {
        
        // indicador de que el token no existe
        boolean aux = true;
        
        // indicador auxiliar para escribir el token que ya existe
        int apunAux = 0;
        
        // si hay mas de un token registrado
        if(numOR > 1) {
            
            // se analiza si el token se ha registrado antes
            for (int i = 0; i < valorOR.size(); i++) {
                
                if (valorOR.get(i).equals(valor)) {
                    
                    // al encontrarse el token, el indicador cambia a false por que el token si existe
                    // y en el otro indicador se guarda cual numero de token es
                    aux = false;
                    apunAux = i;
                }
            }
            
            // despues de analizar, si el token no existe se registra el nuevo token
            if (aux) {
                
                // primero en el ArrayList especifico del token
                tokenOR.add("OR" +numOR);
                valorOR.add(valor);
                
                // despues en el ArrayList donde se escriben todos los tokens
                tokenTodo.add("OR" +numOR);
                valorTodo.add(valor);
                
                // se aumenta el numero de Tokens registrados.
                numOR++;
            }
            
            // si el token existe
            else {
                
                // se registra el token en el ArrayList donde se escriben todos los tokens
                tokenTodo.add(tokenOR.get(apunAux));
                valorTodo.add(valorOR.get(apunAux));
            }
        }
        
        // si es el primer token de su tipo
        else {
            
            // primero en el ArrayList especifico del token
            tokenOR.add("OR" +numOR);
            valorOR.add(valor);
            
            // despues en el ArrayList donde se escriben todos los tokens
            tokenTodo.add("OR" +numOR);
            valorTodo.add(valor);
            
            // se aumenta el numero de Tokens registrados.
            numOR++;
        }
    }
    
    // metodo para guardar un operador aritmetico
    public void setOB(String valor) {
        
        // indicador de que el token no existe
        boolean aux = true;
        
        // indicador auxiliar para escribir el token que ya existe
        int apunAux = 0;
        
        // si hay mas de un token registrado
        if(numOB > 1) {
            
            // se analiza si el token se ha registrado antes
            for (int i = 0; i < valorOB.size(); i++) {
                
                if (valorOB.get(i).equals(valor)) {
                    
                    // al encontrarse el token, el indicador cambia a false por que el token si existe
                    // y en el otro indicador se guarda cual numero de token es
                    aux = false;
                    apunAux = i;
                }
            }
            
            // despues de analizar, si el token no existe se registra el nuevo token
            if (aux) {
                
                // primero en el ArrayList especifico del token
                tokenOB.add("OB" +numOB);
                valorOB.add(valor);
                
                // despues en el ArrayList donde se escriben todos los tokens
                tokenTodo.add("OB" +numOB);
                valorTodo.add(valor);
                
                // se aumenta el numero de Tokens registrados.
                numOB++;
            }
            
            // si el token existe
            else {
                
                // se registra el token en el ArrayList donde se escriben todos los tokens
                tokenTodo.add(tokenOB.get(apunAux));
                valorTodo.add(valorOB.get(apunAux));
            }
        }
        
        // si es el primer token de su tipo
        else {
            
            // primero en el ArrayList especifico del token
            tokenOB.add("OB" +numOB);
            valorOB.add(valor);
            
            // despues en el ArrayList donde se escriben todos los tokens
            tokenTodo.add("OB" +numOB);
            valorTodo.add(valor);
            
            // se aumenta el numero de Tokens registrados.
            numOB++;
        }
    }
    
    // metodo para guardar una constante entera
    public void setCE(String valor) {
        
        // indicador de que el token no existe
        boolean aux = true;
        
        // indicador auxiliar para escribir el token que ya existe
        int apunAux = 0;
        
        // si hay mas de un token registrado
        if(numCE > 1) {
            
            // se analiza si el token se ha registrado antes
            for (int i = 0; i < valorCE.size(); i++) {
                
                if (valorCE.get(i).equals(valor)) {
                    
                    // al encontrarse el token, el indicador cambia a false por que el token si existe
                    // y en el otro indicador se guarda cual numero de token es
                    aux = false;
                    apunAux = i;
                }
            }
            
            // despues de analizar, si el token no existe se registra el nuevo token
            if (aux) {
                
                // primero en el ArrayList especifico del token
                tokenCE.add("CE" +numCE);
                valorCE.add(valor);
                
                // despues en el ArrayList donde se escriben todos los tokens
                tokenTodo.add("CE" +numCE);
                valorTodo.add(valor);
                
                // se aumenta el numero de Tokens registrados.
                numCE++;
            }
            
            // si el token existe
            else {
                
                // se registra el token en el ArrayList donde se escriben todos los tokens
                tokenTodo.add(tokenCE.get(apunAux));
                valorTodo.add(valorCE.get(apunAux));
            }
        }
        
        // si es el primer token de su tipo
        else {
            
            // primero en el ArrayList especifico del token
            tokenCE.add("CE" +numCE);
            valorCE.add(valor);
            
            // despues en el ArrayList donde se escriben todos los tokens
            tokenTodo.add("CE" +numCE);
            valorTodo.add(valor);
            
            // se aumenta el numero de Tokens registrados.
            numCE++;
        }
    }
    
    // metodo para guardar una constante entera
    public void setCF(String valor) {
        
        // indicador de que el token no existe
        boolean aux = true;
        
        // indicador auxiliar para escribir el token que ya existe
        int apunAux = 0;
        
        // si hay mas de un token registrado
        if(numCF > 1) {
            
            // se analiza si el token se ha registrado antes
            for (int i = 0; i < valorCF.size(); i++) {
                
                if (valorCF.get(i).equals(valor)) {
                    
                    // al encontrarse el token, el indicador cambia a false por que el token si existe
                    // y en el otro indicador se guarda cual numero de token es
                    aux = false;
                    apunAux = i;
                }
            }
            
            // despues de analizar, si el token no existe se registra el nuevo token
            if (aux) {
                
                // primero en el ArrayList especifico del token
                tokenCF.add("CF" +numCF);
                valorCF.add(valor);
                
                // despues en el ArrayList donde se escriben todos los tokens
                tokenTodo.add("CF" +numCF);
                valorTodo.add(valor);
                
                // se aumenta el numero de Tokens registrados.
                numCF++;
            }
            
            // si el token existe
            else {
                
                // se registra el token en el ArrayList donde se escriben todos los tokens
                tokenTodo.add(tokenCF.get(apunAux));
                valorTodo.add(valorCF.get(apunAux));
            }
        }
        
        // si es el primer token de su tipo
        else {
            
            // primero en el ArrayList especifico del token
            tokenCF.add("CF" +numCF);
            valorCF.add(valor);
            
            // despues en el ArrayList donde se escriben todos los tokens
            tokenTodo.add("CF" +numCF);
            valorTodo.add(valor);
            
            // se aumenta el numero de Tokens registrados.
            numCF++;
        }
    }
    
    // metodo para guardar un identificador de error léxico
    public void setELX(String valor) {
        
        // indicador de que el token no existe
        boolean aux = true;
        
        // indicador auxiliar para escribir el token que ya existe
        int apunAux = 0;
        
        // si hay mas de un token registrado
        if(numELX > 1) {
            
            // se analiza si el token se ha registrado antes
            for (int i = 0; i < valorELX.size(); i++) {
                
                if (valorELX.get(i).equals(valor)) {
                    
                    // al encontrarse el token, el indicador cambia a false por que el token si existe
                    // y en el otro indicador se guarda cual numero de token es
                    aux = false;
                    apunAux = i;
                }
            }
            
            // despues de analizar, si el token no existe se registra el nuevo token
            if (aux) {
                
                // primero en el ArrayList especifico del token
                tokenELX.add("ELX" +numELX);
                valorELX.add(valor);
                
                /*
                // despues en el ArrayList donde se escriben todos los tokens
                tokenTodo.add("ELX" +numELX);
                valorTodo.add(valor);
                */

                // se aumenta el numero de Tokens registrados.
                numELX++;
                numIDE++;
            }
            
            // si el token existe
            else {
                
                /*
                // se registra el token en el ArrayList donde se escriben todos los tokens
                tokenTodo.add(tokenELX.get(apunAux));
                valorTodo.add(valorELX.get(apunAux));
                */
            }
        }
        
        // si es el primer token de su tipo
        else {
            
            // primero en el ArrayList especifico del token
            tokenELX.add("ELX" +numELX);
            valorELX.add(valor);
            
            /*
            // despues en el ArrayList donde se escriben todos los tokens
            tokenTodo.add("ELX" +numELX);
            valorTodo.add(valor);
            */
            
            // se aumenta el numero de Tokens registrados.
            numELX++;
            numIDE++;
        }
    }
    
    // metodo para guardar un identificador de error semántico
    public void setEST(String valor) {
        
        // indicador de que el token no existe
        boolean aux = true;
        
        // indicador auxiliar para escribir el token que ya existe
        int apunAux = 0;
        
        // si hay mas de un token registrado
        if(numEST > 1) {
            
            // se analiza si el token se ha registrado antes
            for (int i = 0; i < valorEST.size(); i++) {
                
                if (valorEST.get(i).equals(valor)) {
                    
                    // al encontrarse el token, el indicador cambia a false por que el token si existe
                    // y en el otro indicador se guarda cual numero de token es
                    aux = false;
                    apunAux = i;
                }
            }
            
            // despues de analizar, si el token no existe se registra el nuevo token
            if (aux) {
                
                // primero en el ArrayList especifico del token
                tokenEST.add("EST" +numEST);
                valorEST.add(valor);
                
                /*
                // despues en el ArrayList donde se escriben todos los tokens
                tokenTodo.add("EST" +numEST);
                valorTodo.add(valor);
                */
                
                // se aumenta el numero de Tokens registrados.
                numEST++;
            }
            
            // si el token existe
            else {
                
                /*
                // se registra el token en el ArrayList donde se escriben todos los tokens
                tokenTodo.add(tokenEST.get(apunAux));
                valorTodo.add(valorEST.get(apunAux));
                */
            }
        }
        
        // si es el primer token de su tipo
        else {
            
            // primero en el ArrayList especifico del token
            tokenELX.add("EST" +numEST);
            valorELX.add(valor);
            
            /*
            // despues en el ArrayList donde se escriben todos los tokens
            tokenTodo.add("EST" +numEST);
            valorTodo.add(valor);
            */
            
            // se aumenta el numero de Tokens registrados.
            numEST++;
        }
    }
    
    // metodo para guardar una palabra reservada
    public void setPR(String valor) {
        
        // indicador de que el token no existe
        boolean aux = true;
        
        // indicador auxiliar para escribir el token que ya existe
        int apunAux = 0;
        
        // si hay mas de un token registrado
        if(numPR > 1) {
            
            // se analiza si el token se ha registrado antes
            for (int i = 0; i < valorPR.size(); i++) {
                
                if (valorPR.get(i).equals(valor)) {
                    
                    // al encontrarse el token, el indicador cambia a false por que el token si existe
                    // y en el otro indicador se guarda cual numero de token es
                    aux = false;
                    apunAux = i;
                }
            }
            
            // despues de analizar, si el token no existe se registra el nuevo token
            if (aux) {
                
                // primero en el ArrayList especifico del token
                tokenPR.add("PR" +numPR);
                valorPR.add(valor);
                
                // despues en el ArrayList donde se escriben todos los tokens
                tokenTodo.add("PR" +numPR);
                valorTodo.add(valor);
                
                // se aumenta el numero de Tokens registrados.
                numPR++;
            }
            
            // si el token existe
            else {
                
                // se registra el token en el ArrayList donde se escriben todos los tokens
                tokenTodo.add(tokenPR.get(apunAux));
                valorTodo.add(valorPR.get(apunAux));
            }
        }
        
        // si es el primer token de su tipo
        else {
            
            // primero en el ArrayList especifico del token
            tokenPR.add("PR" +numPR);
            valorPR.add(valor);
            
            // despues en el ArrayList donde se escriben todos los tokens
            tokenTodo.add("PR" +numPR);
            valorTodo.add(valor);
            
            // se aumenta el numero de Tokens registrados.
            numPR++;
        }
    }
    
    // agregar caracteres extras
    public void setEXT1() {
        tokenTodo.add("EXT1");
        valorTodo.add("(");
    }
    
    // agregar caracteres extras
    public void setEXT2() {
        tokenTodo.add("EXT2");
        valorTodo.add(")");
    }
    
    // agregar caracteres extras
    public void setSAL1() {
        tokenTodo.add("SAL1");
        valorTodo.add("{");
    }
    
    // agregar caracteres extras
    public void setSAL2() {
        tokenTodo.add("SAL2");
        valorTodo.add("}");
    }
    
    // agregar el operador de asignacion
    public void setOAS() {
        tokenTodo.add("OAS");
        valorTodo.add("=");
    }
    
    // agregar el delimitador
    public void setDEL() {
        tokenTodo.add("DEL");
        valorTodo.add(";");
    }
    
    // obtencion de los datos de token
    public ArrayList<String> getTokenTodo() {
        return tokenTodo;
    }
    
    public ArrayList<String> getValorTodo() {
        return valorTodo;
    }
    
    public ArrayList<String[]> getTokenIDE() {
        return tokenIDE;
    }
    
    public ArrayList<String[]> getValorIDE() {
        return valorIDE;
    }
    
    public ArrayList<String> getTokenOA() {
        return tokenOA;
    }
    
    public ArrayList<String> getValorOA() {
        return valorOA;
    }
    
    public ArrayList<String> getTokenOR() {
        return tokenOR;
    }
    
    public ArrayList<String> getValorOR() {
        return valorOR;
    }
    
    public ArrayList<String> getTokenOB() {
        return tokenOB;
    }
    
    public ArrayList<String> getValorOB() {
        return valorOB;
    }
    
    public ArrayList<String> getTokenCE() {
        return tokenCE;
    }
    
    public ArrayList<String> getValorCE() {
        return valorCE;
    }
    
    public ArrayList<String> getTokenCF() {
        return tokenCF;
    }
    
    public ArrayList<String> getValorCF() {
        return valorCF;
    }
    
    public ArrayList<String> getTokenELX() {
        return tokenELX;
    }
    
    public ArrayList<String> getValorELX() {
        return valorELX;
    }
    
    public ArrayList<String> getTokenPR() {
        return tokenPR;
    }
    
    public ArrayList<String> getValorPR() {
        return valorPR;
    }
    
    public ArrayList<String> getTokenEST() {
        return tokenEST;
    }
    
    public ArrayList<String> getValorEST() {
        return valorEST;
    }
    
    public void reemplazarIDE(ArrayList<String[]> tokenIDE, ArrayList<String[]> valorIDE, ArrayList<String> tokenTodo, ArrayList<String> valorTodo) {
        this.tokenIDE = tokenIDE;
        this.valorIDE = valorIDE;
        this.tokenTodo = tokenTodo;
        this.valorTodo = valorTodo;
    }

}
