package dto;

public class User {
	int uid;
	int gid;
	int atk;

	public User(int uid, int gid) {
		this.setUid(uid);
		this.setGid(gid);
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
