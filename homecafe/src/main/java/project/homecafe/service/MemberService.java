package project.homecafe.service;

import project.homecafe.domain.MemberDTO;

import java.util.List;

public interface MemberService {
    public boolean registerMember(MemberDTO params);
    public MemberDTO getMemberDetail(Long idx);
    public boolean deleteMember(Long idx);
    public List<MemberDTO> getMemberList();
}
