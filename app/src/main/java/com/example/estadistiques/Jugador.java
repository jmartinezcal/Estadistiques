package com.example.estadistiques;



import java.io.Serializable;


public class Jugador implements Serializable {

    String nom, cognom1, dorsal;

    int rof, rdef, tllfallat, tllficat, t2fallat, t2ficat, t3fallat, t3ficat, assist, robat,
    perdues, minutsJugats, mj1, mj2, mj3, mj4, punts, idDrawable, falta_personal, taps;


    public Jugador(){
        rof = 0;
        rdef = 0;
        taps = 0;
        tllfallat = 0;
        tllficat = 0;
        t2fallat = 0;
        t2ficat = 0;
        t3fallat = 0;
        t3ficat = 0;
        assist = 0;
        robat = 0;
        perdues = 0;
        minutsJugats = 0;
        mj1 = 0;
        mj2 = 0;
        mj3 = 0;
        mj4 = 0;
        punts = 0;
        falta_personal = 0;
    }


    public Jugador(String nom, String cognom1, String dorsal, int idDrawable){

        this.nom = nom;
        this.cognom1 = cognom1;
        this.dorsal = dorsal;
        this.idDrawable = idDrawable;

        rof = 0;
        rdef = 0;
        taps = 0;
        tllfallat = 0;
        tllficat = 0;
        t2fallat = 0;
        t2ficat = 0;
        t3fallat = 0;
        t3ficat = 0;
        assist = 0;
        robat = 0;
        perdues = 0;
        minutsJugats = 0;
        mj1 = 0;
        mj2 = 0;
        mj3 = 0;
        mj4 = 0;
        punts = 0;
        falta_personal=0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public int getRof() {
        return rof;
    } //rebot ofensiu

    public void setRof(int rof) {
        this.rof = rof+1;
    }

    public int getRdef() {
        return rdef;
    } //rebot defensiu

    public void setRdef(int rdef) {
        this.rdef = rdef+1;
    }

    public int getTllfallat() {
        return tllfallat;
    }

    public void setTllfallat(int tllfallat) {
        this.tllfallat = tllfallat+1;
    }

    public int getTllficat() {
        return tllficat;
    }

    public void setTllficat(int tllficat) {
        this.tllficat = tllficat+1;
    }

    public int getT2fallat() {
        return t2fallat;
    }

    public void setT2fallat(int t2fallat) {
        this.t2fallat = t2fallat+1;
    }

    public int getT2ficat() {
        return t2ficat;
    }

    public void setT2ficat(int t2ficat) {
        this.t2ficat = t2ficat+1;
    }

    public int getT3fallat() {
        return t3fallat;
    }

    public void setT3fallat(int t3fallat) {
        this.t3fallat = t3fallat+1;
    }

    public int getT3ficat() {
        return t3ficat;
    }

    public void setT3ficat(int t3ficat) {
        this.t3ficat = t3ficat+1;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist+1;
    }

    public int getRobat() {
        return robat;
    }

    public void setRobat(int robat) {
        this.robat = robat+1;
    }

    public int getPerdues() {
        return perdues;
    }

    public void setPerdues(int perdues) {
        this.perdues = perdues+1;
    }

    public int getMinutsJugats() {
        return minutsJugats;
    }

    public void setMinutsJugats(int minutsJugats) {
        this.minutsJugats = minutsJugats;
    }

    public int getMj1() {
        return mj1;
    }

    public void setMj1(int mj1) {
        this.mj1 = mj1;
    }

    public int getMj2() {
        return mj2;
    }

    public void setMj2(int mj2) {
        this.mj2 = mj2;
    }

    public int getMj3() {
        return mj3;
    }

    public void setMj3(int mj3) {
        this.mj3 = mj3;
    }

    public int getMj4() {
        return mj4;
    }

    public void setMj4(int mj4) {
        this.mj4 = mj4;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public int getFalta_personal() {
        return falta_personal;
    }

    public void setFalta_personal(int falta_personal) {
        this.falta_personal = falta_personal+1;
    }

    public int getTaps() {
        return taps;
    }

    public void setTaps(int taps) {
        this.taps = taps +1;
    }
}