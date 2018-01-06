/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.pos.gudang.dao.admin;

import id.ac.pos.gudang.entity.User;
import java.util.ArrayList;

/**
 *
 * @author Oyoy
 */
public interface UserDAO {
    
    ArrayList<User> getUser();
    
    boolean tambahUser(User user);
    
    boolean ubahUser(User user);
    
    String getPassword(String nik);
    
    boolean ubahPassword(User user);
}
