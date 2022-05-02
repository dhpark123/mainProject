package project.homecafe.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.homecafe.domain.MemberDTO;

import java.util.List;

@Mapper
public interface MemberMapper {
    public int insertMember(MemberDTO params);
    public MemberDTO selectMemberDetail(Long idx);
    public int updateMember(MemberDTO params);
    public int deleteMember(Long idx);
    public List<MemberDTO> selectMemberList();
    public int selectMemberTotalCount();
}
