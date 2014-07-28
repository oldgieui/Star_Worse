package dto;


public class Galaxy {

	public Galaxy(int gid, String name) {
		this.setGid(gid);
		this.setName(name);
		this.setHp(100000);
	}

	public Galaxy(int gid, String name, int hp) {
		this.setGid(gid);
		this.setName(name);
		this.setHp(hp);
	}

	int gid;
	String name;
	int hp;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}
