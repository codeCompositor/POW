package pow.cards;

import pow.basic.Board;

public class Card implements Cloneable {
    protected byte player;
    protected Zone zone;
    protected int zoneID;
    private Type type;
    protected String name;
    protected int cost;
    protected int rarity;
    protected int faction;
    protected int race;
    protected int playerClass;
    protected String text;
    protected String inPlayText;
    protected String flavor;

    public Card(String name, int cost, Type type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public int getZoneID() {
        return zoneID;
    }

    public void setZoneID(int zoneID) {
        this.zoneID = zoneID;
    }

    public byte getPlayer() {
        return player;
    }

    public void setPlayer(byte player) {
        this.player = player;
    }

    public void die(Board board) {}

    public void play(Board board) {}
}
