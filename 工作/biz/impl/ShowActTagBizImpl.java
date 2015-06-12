package com.icode.chengcheng.biz.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.icode.chengcheng.biz.IShowActTagBiz;
import com.icode.chengcheng.dao.IActivitiesDao;
import com.icode.chengcheng.dao.IHobbiesDao;
import com.icode.chengcheng.dao.IShowActTagDao;
import com.icode.chengcheng.dao.ITagsDao;
import com.icode.chengcheng.dao.impl.ActivitiesDaoImpl;
import com.icode.chengcheng.dao.impl.HobbiesDaoImpl;
import com.icode.chengcheng.dao.impl.ShowActTagDaoImpl;
import com.icode.chengcheng.dao.impl.TagsDaoImpl;
import com.icode.chengcheng.po.Hobbies;
import com.icode.chengcheng.po.Tags;
import com.icode.chengcheng.vo.ShowActTag;

public class ShowActTagBizImpl implements IShowActTagBiz {
	
	private IShowActTagDao iShowActTagDao;
	private IHobbiesDao iHobbiesDao;
	private IActivitiesDao iActivitiesDao;
	private ITagsDao iTagsDao;

	public ShowActTagBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.iShowActTagDao = new ShowActTagDaoImpl();
		this.iHobbiesDao = new HobbiesDaoImpl();
		this.iActivitiesDao = new ActivitiesDaoImpl();
		this.iTagsDao = new TagsDaoImpl();
	}

	@Override
	public List<ShowActTag> selectAct(String uccid) {
		// TODO Auto-generated method stub
		List<Hobbies> lstUserHobbies= iHobbiesDao.selectById2(uccid);//用户爱好标签列表
		List<Integer> lstTid =new ArrayList<Integer>();    //爱好对应活动tid列表
		List<ShowActTag> lstActTag=new ArrayList<ShowActTag>() ;
		for(Hobbies h:lstUserHobbies){   
             lstTid.add(h.getHtag());
             System.out.println(lstTid);
        }   
		
		for(int tid:lstTid)
		{
			lstActTag.addAll(iShowActTagDao.selectByTag(tid));
			//System.out.println(lstActTag);
		}
		Collections.sort(lstActTag, new Comparator<ShowActTag>() {

			@Override
			public int compare(ShowActTag o1, ShowActTag o2) {
				// TODO Auto-generated method stub
				return o2.getAdate().compareTo(o1.getAdate());
			}
			
		});
		return lstActTag;
	}

	@Override
	public List<ShowActTag> selectActByheat(String uccid) {
		// TODO Auto-generated method stub
		List<Hobbies> lstUserHobbies= iHobbiesDao.selectById2(uccid);//用户爱好标签列表
		List<Integer> lstTid =new ArrayList<Integer>();    //爱好对应活动tid列表
		List<ShowActTag> lstActTagByheat=new ArrayList<ShowActTag>();
		for(Hobbies h:lstUserHobbies){   
             lstTid.add(h.getHtag());
             System.out.println(lstTid);
        }   
		
		for(int tid:lstTid)
		{
			lstActTagByheat.addAll(iShowActTagDao.selectByTag(tid));
			//System.out.println(lstActTag);
		}
		Collections.sort(lstActTagByheat, new Comparator<ShowActTag>() {

			@Override
			public int compare(ShowActTag o1, ShowActTag o2) {
				// TODO Auto-generated method stub
				int comm1=iActivitiesDao.selectById(o1.getAid()).getAshare_num();
				int comm2=iActivitiesDao.selectById(o2.getAid()).getAshare_num();
				if(comm1>comm2) return -1;
				else if(comm1==comm2) return 0;
				else return 1;
				
			}
			
		});
		return lstActTagByheat;
	}

	@Override
	public List<ShowActTag> selectActBycomm(String uccid) {
		// TODO Auto-generated method stub
		List<Hobbies> lstUserHobbies= iHobbiesDao.selectById2(uccid);//用户爱好标签列表
		List<Integer> lstTid =new ArrayList<Integer>();    //爱好对应活动tid列表
		List<ShowActTag> lstActTagBycomm=new ArrayList<ShowActTag>() ;
		for(Hobbies h:lstUserHobbies){   
             lstTid.add(h.getHtag());
             System.out.println(lstTid);
        }   
		
		for(int tid:lstTid)
		{
			lstActTagBycomm.addAll(iShowActTagDao.selectByTag(tid));
			//System.out.println(lstActTag);
		}
		Collections.sort(lstActTagBycomm, new Comparator<ShowActTag>() {

			@Override
			public int compare(ShowActTag o1, ShowActTag o2) {
				// TODO Auto-generated method stub
				int comm1=iActivitiesDao.selectById(o1.getAid()).getAcomm_num();
				int comm2=iActivitiesDao.selectById(o2.getAid()).getAcomm_num();
				if(comm1>comm2) return -1;
				else if(comm1==comm2) return 0;
				else return 1;
				
			}
			
		});
		return lstActTagBycomm;
	}

	@Override
	public List<ShowActTag> selectActBycurr(String uccid) {
		// TODO Auto-generated method stub
		List<Hobbies> lstUserHobbies= iHobbiesDao.selectById2(uccid);//用户爱好标签列表
		List<Integer> lstTid =new ArrayList<Integer>();    //爱好对应活动tid列表
		List<ShowActTag> lstActTagBycurr=new ArrayList<ShowActTag>() ;
		for(Hobbies h:lstUserHobbies){   
             lstTid.add(h.getHtag());
             System.out.println(lstTid);
        }   
		
		for(int tid:lstTid)
		{
			lstActTagBycurr.addAll(iShowActTagDao.selectByTag(tid));
			//System.out.println(lstActTag);
		}
		Collections.sort(lstActTagBycurr, new Comparator<ShowActTag>() {

			@Override
			public int compare(ShowActTag o1, ShowActTag o2) {
				// TODO Auto-generated method stub
				int comm1=iActivitiesDao.selectById(o1.getAid()).getAcurr_num();
				int comm2=iActivitiesDao.selectById(o2.getAid()).getAcurr_num();
				if(comm1>comm2) return -1;
				else if(comm1==comm2) return 0;
				else return 1;
				
			}
			
		});
		return lstActTagBycurr;
	}

	@Override
	public List<Tags> selectHobby(String uccid) {
		// TODO Auto-generated method stub
		List<Hobbies> lstUserHobbies= iHobbiesDao.selectById2(uccid);//用户爱好标签列表
		List<Tags> lstTid =new ArrayList<Tags>();
		for(Hobbies h:lstUserHobbies){
			System.out.println("用户爱好"+lstUserHobbies);
			lstTid.add(iTagsDao.selectById(h.getHtag()));
            //System.out.println(lstTid);
       }   
		return lstTid;
	}

	@Override
	public List<ShowActTag> selectActByhobby(List<Integer> lstTid) {
		// TODO Auto-generated method stub
		List<ShowActTag> lstActTagByhobby=new ArrayList<ShowActTag>() ;
		for(int tid:lstTid)
		{
			lstActTagByhobby.addAll(iShowActTagDao.selectByTag(tid));
			//System.out.println(lstActTag);
		}
		Collections.sort(lstActTagByhobby, new Comparator<ShowActTag>() {

			@Override
			public int compare(ShowActTag o1, ShowActTag o2) {
				// TODO Auto-generated method stub
				return o2.getAdate().compareTo(o1.getAdate());
			}
			
		});
		return lstActTagByhobby;
	}

	@Override
	public List<ShowActTag> selectActByaid(List<Integer> lstAid) {
		// TODO Auto-generated method stub
		List<ShowActTag> lstActTagByaid=new ArrayList<ShowActTag>() ;
		for(int aid:lstAid)
		{
			lstActTagByaid.addAll(iShowActTagDao.selectById(aid));
			System.out.println(lstActTagByaid);
		}
		Collections.sort(lstActTagByaid, new Comparator<ShowActTag>() {

			@Override
			public int compare(ShowActTag o1, ShowActTag o2) {
				// TODO Auto-generated method stub
				return o2.getAdate().compareTo(o1.getAdate());
			}
			
		});
		return lstActTagByaid;
	}


	}


