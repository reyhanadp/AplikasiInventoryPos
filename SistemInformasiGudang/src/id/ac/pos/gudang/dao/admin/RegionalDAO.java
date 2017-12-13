/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.pos.gudang.dao.admin;

import id.ac.pos.gudang.entity.Regional;
import java.util.ArrayList;

/**
 *
 * @author Oyoy
 */
public interface RegionalDAO {
    
    ArrayList<Regional> getRegional();
    
    ArrayList<Regional> cariRegional(String keyword);
    
    boolean tambahRegional(Regional regional);
    
    boolean hapusRegional(String idRegional);
    
    boolean ubahRegional(Regional regional);
          
}
