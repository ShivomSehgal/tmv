package com.example.project;


public class DsaSubclass {
    private String dsaTopic;
    private String dsaProfLvl;
    private String dsaQuesRatio;
    private String dsaSub;


    public DsaSubclass(String dsaTopic, String dsaProfLvl){
        this.dsaTopic = dsaTopic;
        this.dsaProfLvl = dsaProfLvl;
        this.dsaQuesRatio = "Prof Required :";
    }
    public DsaSubclass(String dsaTopic, String dsaProfLvl, String dsaSub){

        this.dsaTopic = dsaTopic;
        this.dsaProfLvl = dsaProfLvl;
        this.dsaQuesRatio = "Prof Required :";
        this.dsaSub = dsaSub;
    }

    public String getDsaTopic() {
        return dsaTopic;
    }

    public String getDsaProfLvl() {
        return dsaProfLvl;
    }

    public String getDsaQuesRatio() {
        return dsaQuesRatio;
    }

    public String getDsaSub() {
        return dsaSub;
    }
}
