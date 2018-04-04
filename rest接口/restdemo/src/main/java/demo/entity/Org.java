package demo.entity;
/**
 * 组织实体类
 */
public class Org {
    private String ono;

    private String oname;

    public String getOno() {
        return ono;
    }

    public void setOno(String ono) {
        this.ono = ono == null ? null : ono.trim();
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

	@Override
	public String toString() {
		return "Org [ono=" + ono + ", oname=" + oname + "]";
	}
}