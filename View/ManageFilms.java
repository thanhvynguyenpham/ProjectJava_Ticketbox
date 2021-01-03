/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.Color;
import javax.swing.*;
import java.awt.Component;
import java.util.ArrayList;
import DAO.FilmDAO;
import Model.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author nguye
 */
public class ManageFilms extends javax.swing.JFrame {

    /**
     * Creates new form MannageUsers
     */
    Admin admin = null;
    ArrayList<ArrayList<JLabel>> lstLab = null;
    ManageFilms film = this;
    int mpX, mpY;
    public ManageFilms(Admin admin) {
        this.admin = admin;
        initComponents();
        getShowtimes();
        
        
        
        
        
        
              
        
        //System.out.println(getClass().getResource("/images/exit.png"));
        //System.out.println(getClass().getResource("/images/logo.png"));
    }
    
    public void getShowtimes(){
        panel_st.removeAll();
        
        ArrayList<Film> lsFilm = new ArrayList<>();
        lsFilm = FilmDAO.getAllFilm();
        System.out.println(lsFilm);
        
        lstLab = new ArrayList<>();
        for (Film i:lsFilm){
             JPanel panel = new javax.swing.JPanel();
             panel.setPreferredSize(new Dimension(270,400));
             panel.setBackground(Color.white);
             JLabel lab = new JLabel(i.getTitle());
             System.out.println(i.getLinkimg());
             lab.setIcon(new javax.swing.ImageIcon(getClass().getResource(i.getLinkimg())));
             lab.setFont(new java.awt.Font("Segoe UI", 0, 14));
             lab.setForeground(new Color(122,72,221));
             lab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
             lab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
             JLabel br = new JLabel("  ");
             JLabel trash = new JLabel("");
             JLabel add = new JLabel("");
             JLabel edit = new JLabel("");
             trash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash.png")));
             add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_20px.png")));
             edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png")));
             //lab.setAlignmentY(TOP_ALIGNMENT);
             //panel.setLayout(new BorderLayout(0,10));
             panel.add(lab);
             panel.add(br);
             
             panel.add(edit);
             panel.add(add);
             panel.add(trash);
             
             trash.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int confirm= JOptionPane.showConfirmDialog(body, "Do you really want to delete this showtime");
                        if (confirm == JOptionPane.YES_OPTION){
                            boolean res = FilmDAO.deleteAFilm(i);
                            getShowtimes();
                        }
                        
                    }
                    
                });
             trash.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
             edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
             add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        panel_st.add(panel);
             add.addMouseListener(new MouseAdapter() {
                 public void mouseClicked(MouseEvent e){
                     new AddAFilms(admin).setVisible(true);
                     film.dispose();
                 }
                     
             });
             edit.addMouseListener(new MouseAdapter() {
                 public void mouseClicked(MouseEvent e){
                     new EditAFilm(i,admin).setVisible(true);
                     film.dispose();
                 }
                     
             });
             
        }
        this.validate();
        this.repaint();
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        header_top = new javax.swing.JPanel();
        menu_top = new javax.swing.JPanel();
        btn_exit = new javax.swing.JPanel();
        lab_exit = new javax.swing.JLabel();
        btn_min = new javax.swing.JPanel();
        lab_min = new javax.swing.JLabel();
        btn_max = new javax.swing.JPanel();
        lab_max = new javax.swing.JLabel();
        header_bottom = new javax.swing.JPanel();
        main_menu = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        lab_home = new javax.swing.JLabel();
        btn_accounts = new javax.swing.JPanel();
        lab_accounts = new javax.swing.JLabel();
        btn_films = new javax.swing.JPanel();
        lab_films = new javax.swing.JLabel();
        btn_showtimes = new javax.swing.JPanel();
        lab_showtimes = new javax.swing.JLabel();
        btn_revenue = new javax.swing.JPanel();
        lab_revenue = new javax.swing.JLabel();
        logout_pannel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_st = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        header.setBackground(new java.awt.Color(64, 33, 100));
        header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        header.setPreferredSize(new java.awt.Dimension(800, 80));
        header.setLayout(new java.awt.BorderLayout());

        header_top.setBackground(new java.awt.Color(64, 33, 100));
        header_top.setPreferredSize(new java.awt.Dimension(400, 30));
        header_top.setLayout(new java.awt.BorderLayout());

        menu_top.setBackground(new java.awt.Color(64, 33, 100));
        menu_top.setPreferredSize(new java.awt.Dimension(150, 30));
        menu_top.setLayout(new java.awt.BorderLayout());

        btn_exit.setBackground(new java.awt.Color(64, 33, 100));
        btn_exit.setMinimumSize(new java.awt.Dimension(25, 25));
        btn_exit.setPreferredSize(new java.awt.Dimension(50, 30));
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_exitMouseExited(evt);
            }
        });
        btn_exit.setLayout(new java.awt.BorderLayout());

        lab_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        lab_exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_exit.add(lab_exit, java.awt.BorderLayout.CENTER);

        menu_top.add(btn_exit, java.awt.BorderLayout.EAST);

        btn_min.setBackground(new java.awt.Color(64, 33, 100));
        btn_min.setPreferredSize(new java.awt.Dimension(50, 30));
        btn_min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_minMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_minMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_minMouseExited(evt);
            }
        });
        btn_min.setLayout(new java.awt.BorderLayout());

        lab_min.setBackground(new java.awt.Color(24, 24, 24));
        lab_min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/min.png"))); // NOI18N
        lab_min.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lab_min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_minMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lab_minMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lab_minMouseExited(evt);
            }
        });
        btn_min.add(lab_min, java.awt.BorderLayout.CENTER);

        menu_top.add(btn_min, java.awt.BorderLayout.WEST);

        btn_max.setBackground(new java.awt.Color(64, 33, 100));
        btn_max.setPreferredSize(new java.awt.Dimension(50, 30));
        btn_max.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_maxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_maxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_maxMouseExited(evt);
            }
        });
        btn_max.setLayout(new java.awt.BorderLayout());

        lab_max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/max.png"))); // NOI18N
        btn_max.add(lab_max, java.awt.BorderLayout.CENTER);

        menu_top.add(btn_max, java.awt.BorderLayout.CENTER);

        header_top.add(menu_top, java.awt.BorderLayout.LINE_END);

        header.add(header_top, java.awt.BorderLayout.PAGE_START);

        header_bottom.setBackground(new java.awt.Color(64, 33, 100));
        header_bottom.setAlignmentX(Component.CENTER_ALIGNMENT);
        header_bottom.setMinimumSize(new java.awt.Dimension(800, 30));
        header_bottom.setPreferredSize(new java.awt.Dimension(800, 50));

        main_menu.setBackground(new java.awt.Color(64, 33, 100));
        main_menu.setPreferredSize(new java.awt.Dimension(700, 30));
        main_menu.setLayout(new java.awt.GridLayout(1, 6));

        btn_home.setBackground(new java.awt.Color(64, 33, 100));
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_homeMouseExited(evt);
            }
        });
        btn_home.setLayout(new java.awt.BorderLayout());

        lab_home.setBackground(new java.awt.Color(64, 33, 100));
        lab_home.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_home.setForeground(new java.awt.Color(255, 255, 255));
        lab_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        lab_home.setText("Home");
        lab_home.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_home.add(lab_home, java.awt.BorderLayout.CENTER);

        main_menu.add(btn_home);

        btn_accounts.setBackground(new java.awt.Color(64, 33, 100));
        btn_accounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_accountsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_accountsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_accountsMouseExited(evt);
            }
        });
        btn_accounts.setLayout(new java.awt.BorderLayout());

        lab_accounts.setBackground(new java.awt.Color(64, 33, 100));
        lab_accounts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_accounts.setForeground(new java.awt.Color(255, 255, 255));
        lab_accounts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_accounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account1.png"))); // NOI18N
        lab_accounts.setText("Accounts");
        lab_accounts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_accounts.add(lab_accounts, java.awt.BorderLayout.CENTER);

        main_menu.add(btn_accounts);

        btn_films.setBackground(new java.awt.Color(64, 33, 100));
        btn_films.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_filmsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_filmsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_filmsMouseExited(evt);
            }
        });
        btn_films.setLayout(new java.awt.BorderLayout());

        lab_films.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lab_films.setForeground(new java.awt.Color(255, 255, 255));
        lab_films.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_films.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/film.png"))); // NOI18N
        lab_films.setText("Films");
        lab_films.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_films.add(lab_films, java.awt.BorderLayout.CENTER);

        main_menu.add(btn_films);

        btn_showtimes.setBackground(new java.awt.Color(64, 33, 100));
        btn_showtimes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_showtimesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_showtimesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_showtimesMouseExited(evt);
            }
        });
        btn_showtimes.setLayout(new java.awt.BorderLayout());

        lab_showtimes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_showtimes.setForeground(new java.awt.Color(255, 255, 255));
        lab_showtimes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_showtimes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/showtimes.png"))); // NOI18N
        lab_showtimes.setText("Showtimes");
        lab_showtimes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_showtimes.add(lab_showtimes, java.awt.BorderLayout.CENTER);

        main_menu.add(btn_showtimes);

        btn_revenue.setBackground(new java.awt.Color(64, 33, 100));
        btn_revenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_revenueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_revenueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_revenueMouseExited(evt);
            }
        });
        btn_revenue.setLayout(new java.awt.BorderLayout());

        lab_revenue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_revenue.setForeground(new java.awt.Color(255, 255, 255));
        lab_revenue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_revenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/revenue.png"))); // NOI18N
        lab_revenue.setText(" Revenue");
        lab_revenue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_revenue.add(lab_revenue, java.awt.BorderLayout.CENTER);

        main_menu.add(btn_revenue);

        logout_pannel.setBackground(new java.awt.Color(64, 33, 100));
        logout_pannel.setLayout(new java.awt.BorderLayout());

        logout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.setText("Log out");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout_pannel.add(logout, java.awt.BorderLayout.CENTER);

        main_menu.add(logout_pannel);

        header_bottom.add(main_menu);

        header.add(header_bottom, java.awt.BorderLayout.CENTER);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(64, 33, 100)));
        body.setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(10, 100));
        jPanel1.setLayout(new java.awt.GridLayout(1, 1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(140, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 100));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FILM");
        jLabel4.setBackground(new java.awt.Color(64, 33, 100));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(64, 33, 100));
        jPanel2.add(jLabel4);

        jPanel3.add(jPanel2);

        jPanel1.add(jPanel3);

        body.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        panel_st.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(panel_st);

        body.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(800, 516));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseEntered
        // TODO add your handling code here:
        btn_exit.setBackground(Color.red);
    }//GEN-LAST:event_btn_exitMouseEntered

    private void btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_btn_exitMouseClicked

    private void btn_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseExited
        // TODO add your handling code here:
        btn_exit.setBackground(new Color(64,33,100));
    }//GEN-LAST:event_btn_exitMouseExited

    private void btn_minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_minMouseClicked

    private void btn_minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minMouseEntered
        // TODO add your handling code here:
        btn_min.setBackground(new Color(37,12,65));
    }//GEN-LAST:event_btn_minMouseEntered

    private void btn_minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minMouseExited
        // TODO add your handling code here:
        btn_min.setBackground(new Color(64,33,100));
    }//GEN-LAST:event_btn_minMouseExited

    private void btn_maxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maxMouseClicked
        // TODO add your handling code here:
        if(this.getExtendedState()!=MAXIMIZED_BOTH){
            this.setExtendedState(MAXIMIZED_BOTH);
        }
        else{
            this.setExtendedState(NORMAL);
        }
    }//GEN-LAST:event_btn_maxMouseClicked

    private void btn_maxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maxMouseEntered
        // TODO add your handling code here:
        btn_max.setBackground(new Color(37,12,65));
    }//GEN-LAST:event_btn_maxMouseEntered

    private void btn_maxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maxMouseExited
        // TODO add your handling code here:
        btn_max.setBackground(new Color(64,33,100));
    }//GEN-LAST:event_btn_maxMouseExited

    private void lab_minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_minMouseClicked
        // TODO add your handling code here:
        setState(this.ICONIFIED);
        
    }//GEN-LAST:event_lab_minMouseClicked

    private void lab_minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_minMouseEntered
        // TODO add your handling code here:
        btn_min.setBackground(new Color(37,12,65));
    }//GEN-LAST:event_lab_minMouseEntered

    private void lab_minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_minMouseExited
        // TODO add your handling code here:
        btn_min.setBackground(new Color(64,33,100));
    }//GEN-LAST:event_lab_minMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        mpX = evt.getX();
        mpY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        setLocation(getLocation().x + evt.getX() - mpX,getLocation().y + evt.getY() - mpY );
    }//GEN-LAST:event_formMouseDragged

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:
        new AdminView(admin).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        // TODO add your handling code here:
        btn_home.setBackground(new Color(37,12,65));
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        // TODO add your handling code here:
        btn_home.setBackground(new Color(64,33,100));
    }//GEN-LAST:event_btn_homeMouseExited

    private void btn_accountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accountsMouseClicked
        // TODO add your handling code here:
        new MannageUsers(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_accountsMouseClicked

    private void btn_accountsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accountsMouseEntered
        // TODO add your handling code here:
        btn_accounts.setBackground(new Color(37,12,65));
    }//GEN-LAST:event_btn_accountsMouseEntered

    private void btn_accountsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accountsMouseExited
        // TODO add your handling code here:
        btn_accounts.setBackground(new Color(64,33,100));
    }//GEN-LAST:event_btn_accountsMouseExited

    private void btn_filmsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_filmsMouseClicked
        // TODO add your handling code here:
        new ManageFilms(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_filmsMouseClicked

    private void btn_filmsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_filmsMouseEntered
        // TODO add your handling code here:
        btn_films.setBackground(new Color(37,12,65));
    }//GEN-LAST:event_btn_filmsMouseEntered

    private void btn_filmsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_filmsMouseExited
        // TODO add your handling code here:
        btn_films.setBackground(new Color(64,33,100));
    }//GEN-LAST:event_btn_filmsMouseExited

    private void btn_showtimesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_showtimesMouseClicked
        // TODO add your handling code here:
        new ManageShowtimes(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_showtimesMouseClicked

    private void btn_showtimesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_showtimesMouseEntered
        // TODO add your handling code here:
        btn_showtimes.setBackground(new Color(37,12,65));
    }//GEN-LAST:event_btn_showtimesMouseEntered

    private void btn_showtimesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_showtimesMouseExited
        // TODO add your handling code here:
        btn_showtimes.setBackground(new Color(64,33,100));
    }//GEN-LAST:event_btn_showtimesMouseExited

    private void btn_revenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_revenueMouseClicked
        // TODO add your handling code here:
        new ManageRevenue(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_revenueMouseClicked

    private void btn_revenueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_revenueMouseEntered
        // TODO add your handling code here:
        btn_revenue.setBackground(new Color(37,12,65));
    }//GEN-LAST:event_btn_revenueMouseEntered

    private void btn_revenueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_revenueMouseExited
        // TODO add your handling code here:
        btn_revenue.setBackground(new Color(64,33,100));
    }//GEN-LAST:event_btn_revenueMouseExited

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        new SignInView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        // TODO add your handling code here:
        logout.setFont(new java.awt.Font("Segoe UI", 1, 14));
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        // TODO add your handling code here:
        logout.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }//GEN-LAST:event_logoutMouseExited
     
    /**
     * @param args the command line arguments
     */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel btn_accounts;
    private javax.swing.JPanel btn_exit;
    private javax.swing.JPanel btn_films;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel btn_max;
    private javax.swing.JPanel btn_min;
    private javax.swing.JPanel btn_revenue;
    private javax.swing.JPanel btn_showtimes;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header_bottom;
    private javax.swing.JPanel header_top;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lab_accounts;
    private javax.swing.JLabel lab_exit;
    private javax.swing.JLabel lab_films;
    private javax.swing.JLabel lab_home;
    private javax.swing.JLabel lab_max;
    private javax.swing.JLabel lab_min;
    private javax.swing.JLabel lab_revenue;
    private javax.swing.JLabel lab_showtimes;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel logout_pannel;
    private javax.swing.JPanel main_menu;
    private javax.swing.JPanel menu_top;
    private javax.swing.JPanel panel_st;
    // End of variables declaration//GEN-END:variables
}