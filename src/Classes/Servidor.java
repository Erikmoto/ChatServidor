/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interface.InterfaceServidor;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ryuic
 */
public class Servidor {
    
    private int porta;
    private String IP;
    private List<PrintStream> clientes;
    private ServerSocket servidor;
    private InterfaceServidor interfaceServidor;

    public Servidor (int porta) {
        try {
            this.IP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            
        }
        this.porta = porta;
        this.clientes = new ArrayList<PrintStream>();
        this.interfaceServidor = new InterfaceServidor(this);
        this.interfaceServidor.setVisible(true);
    }

    public void executa () throws IOException {
        this.servidor = new ServerSocket(this.porta);
        System.out.println("Porta " + this.porta + " aberta!");

        while (true) {
            // aceita um cliente
            Socket cliente = this.servidor.accept();
            System.out.println("Nova conexão com o cliente " +   
                cliente.getInetAddress().getHostAddress()
            );

            // adiciona saida do cliente à lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);

            // cria tratador de cliente numa nova thread
            TrataCliente tc = new TrataCliente(cliente.getInputStream(), this);
            new Thread(tc).start();
        }
    }
    
    public void paraServidor() {
        for(int i = 0; i < clientes.size(); i++) {
            clientes.get(i).println("Servidor fechado");
            this.clientes.get(i).close();
        }
        
        this.clientes.clear();
        
        try {
            servidor.close();
        } catch (IOException ex) {
            System.out.println("Servidor fechado");
        }
    }

    public void distribuiMensagem(String mensagemManchester) {
        String mensagemBinario = converteManchesterParaBinario(mensagemManchester);
        String mensagem = converteBinarioParaString(mensagemBinario);
        
        this.interfaceServidor.imprimeMensagem("Manchester: " + mensagemManchester + "\n" + "Binário: " + mensagemBinario + "\n" + "Mensagem: " + mensagem + "\n");
        
        // envia mensagemManchester para todo mundo
        for (PrintStream cliente : this.clientes) {
            cliente.println(mensagemManchester + "\n");
        }
    }
    
    private String converteManchesterParaBinario(String mensagemManchester) {
        String mensagemBinario = "";
        
        for(int i = 0; i < mensagemManchester.length(); i += 2) {
            if(mensagemManchester.charAt(i) == '0') {
                mensagemBinario = mensagemBinario + "1";
            }
            
            else {
                mensagemBinario = mensagemBinario + "0";
            }
        }
        
        return mensagemBinario;
    }
    
    private String converteBinarioParaString(String mensagemBinario) {
        String mensagem = "";
        char caractere;
        int decimal = 0;
        int posicaoBit = 15;
        int binario;
        
        for (int i = 1; i < mensagemBinario.length() + 1; i++) {
            binario = Integer.parseInt(mensagemBinario.substring(i-1, i));
            
            System.out.println("Binário: " + binario + " - " + "Soma: " + decimal + " - " + "Posição: " + posicaoBit);
            
            if(posicaoBit == 0) {
                if(binario == 1) {
                    decimal = (int) (decimal + Math.pow(2, posicaoBit));
                }
                
                caractere = (char)decimal;
                System.out.println(caractere);
                mensagem = mensagem + caractere;
                decimal = 0;
                posicaoBit = 15;
            }
            
            else {
                if(binario == 1) {
                    decimal = (int) (decimal + Math.pow(2, posicaoBit));
                }
                
                posicaoBit--;
            }
        }
        
        return mensagem;
    }

    public int getPorta() {
        return porta;
    }

    public String getIP() {
        return IP;
    }
    
    public static void main(String[] args) throws IOException {
     // inicia o servidor
     new Servidor(6500).executa();
   }
}