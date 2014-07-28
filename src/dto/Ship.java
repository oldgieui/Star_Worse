package dto;

public class Ship {
	int sid;
	int uid;
	int gid;
	int atk;
	
	public Ship(int sid, int uid, int gid, int atk) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.gid = gid;
		this.atk = atk;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

}
