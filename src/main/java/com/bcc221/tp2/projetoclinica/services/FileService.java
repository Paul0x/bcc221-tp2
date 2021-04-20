/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.services;

import com.bcc221.tp2.projetoclinica.entities.RegistroPagamento;
import com.bcc221.tp2.projetoclinica.entities.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author paulo
 */
public class FileService {

    private static final String usuarioFilePath = "usuariosObj.dat";
    private static final String pagamentosFilePath = "pagamentosObj.dat";

    public void saveFullFile(List<Usuario> usuarios, List<RegistroPagamento> pagamentos) throws IOException {
        try {

            FileOutputStream fileOut = new FileOutputStream(usuarioFilePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(usuarios);
            objectOut.close();

            fileOut = new FileOutputStream(pagamentosFilePath);
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(pagamentos);
            objectOut.close();

        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public List<Usuario> readUsuariosFile() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream(usuarioFilePath);
            List<Usuario> usuarios;
            try (ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                usuarios = (List<Usuario>) objectIn.readObject();
            }
            return usuarios;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
      public List<RegistroPagamento> readPagamentosFile() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream(pagamentosFilePath);
            List<RegistroPagamento> pagamentos;
            try (ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                pagamentos = (List<RegistroPagamento>) objectIn.readObject();
            }
            return pagamentos;
        } catch (Exception ex) {
            throw ex;
        }
    }

}

