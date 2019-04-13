package com.reptilesysem.system.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.reptilesysem.system.core.dto.RuleDto;
import org.dom4j.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.reptilesysem.system.core.dao.IRuleHtmlRefDao;
import com.reptilesysem.system.core.dao.IRulesDao;
import com.reptilesysem.system.core.pojo.RuleHtmlInfoRef;
import com.reptilesysem.system.core.pojo.Rules;
import com.reptilesysem.system.core.service.IRulesService;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class RulesServiceImpl implements IRulesService{

	@Autowired
	private IRulesDao rulesDao;
	
	@Autowired
	private IRuleHtmlRefDao ruleRefDao;


	@Override
	public Rules saveRule(Rules rules) {
		return rulesDao.save(rules);
	}

	@Override
	public List<Rules> getAllRulesByMid(RuleDto dto) {
		return rulesDao.findAll(new Spec(dto));
	}

	@Override
	public List<Rules> getAllRules() {
		return (List<Rules>) rulesDao.finaAllRules();
	}

	@Override
	public List<Rules> getRulesByHtmlId(String htmlId) {
		List<RuleHtmlInfoRef> ruleRefs = ruleRefDao.findByHtmlInfoId(htmlId);
 		List<Rules> rules = new ArrayList<Rules>();
		ruleRefs.stream().forEach((Item) -> {
			Rules rule = rulesDao.findById(Item.getRuleId()).get();
			rules.add(rule);
		});
	    return rules;
	}

    @Override
    public Integer freezeRule(String ruleId) {
        return 1;
    }

    class Spec implements Specification<Rules> {

	    private RuleDto rule;

	    public Spec(RuleDto rule){
	        this.rule = rule;
        }

		@Nullable
		@Override
		public Predicate toPredicate(Root<Rules> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
		    List<Predicate> pres = new ArrayList<Predicate>();
		    if(!ObjectUtils.isEmpty(rule.getMid())){
		        pres.add(criteriaBuilder.equal(root.get("mid").as(String.class), rule.getMid()));
            }
            Predicate[] p = new Predicate[pres.size()];
			return criteriaBuilder.and(pres.toArray(p));
		}
	}
}
