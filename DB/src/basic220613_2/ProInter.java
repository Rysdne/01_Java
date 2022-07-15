package basic220613_2;

import java.util.List;

public interface ProInter {

	public int insert(ProVO prv);

	public List<ProVO> findAll();

	public ProVO findOne(String pronum);

	public boolean exist(String pronum);

	public int update(ProVO prv);

	public int delete(ProVO prv);

}
