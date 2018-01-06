/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.pos.gudang.dao.admin;

import id.ac.pos.gudang.entity.Mitra;
import java.util.ArrayList;

/**
 *
 * @author Oyoy
 */
public interface MitraDAO {
    
    ArrayList<Mitra> getMitra();
    
    ArrayList<Mitra> cariMitra(String keyword);
    
    boolean tambahMitra(Mitra mitra);
    
    boolean ubahMitra(Mitra mitra);
    
}
