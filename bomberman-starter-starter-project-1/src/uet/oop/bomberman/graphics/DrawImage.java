/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uet.oop.bomberman.graphics;

/**
 *
 * @author Minh Anh
 */
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
public class DrawImage extends JFrame {

    Image img;

    public DrawImage(int a) {
        this.setSize(720,655);
//L?y hình ?nh c?n hi?n th?
        if(a==0)  img=this.getToolkit().getImage("1.jpg");
        else if(a==1) img=this.getToolkit().getImage("win1.jpg");
        else img =this.getToolkit().getImage("over.jpg");
    }

    public void paint(Graphics g){
    //V? hình vào khung c?a s?
        g.drawImage(img,0,0,this);

    }

    public static void main(String args[]){
        DrawImage dr=new DrawImage(1);
      
        dr.show();

    }
}
