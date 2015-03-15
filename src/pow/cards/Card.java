package pow.cards;

import pow.basic.Board;

public class Card implements Cloneable {
    protected int player;
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

    public Card(String name, int cost, Type type, int player) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.player = player;
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

    public void die(Board board) {}
}
