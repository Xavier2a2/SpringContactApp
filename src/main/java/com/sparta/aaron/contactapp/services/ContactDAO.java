package com.sparta.aaron.contactapp.services;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ContactDAO
//        extends JdbcDaoSupport
{
//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SpringContactApp");
//    EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//    public ContactsEntity findContactById(int id) {
//        return entityManager.find(ContactsEntity.class, id);
//    }
//
//    public List<ContactsEntity> getAllContacts() {
//        return entityManager.createNamedQuery("Contacts.getAllContacts",
//                ContactsEntity.class).getResultList();
//    }
//
//    public List<ContactsEntity> getContactByUserID(int id){
//        return entityManager.createQuery(
//                "select * from contacts c where c.user_id = :id",
//                ContactsEntity.class).setParameter("id", id)
//                .getResultList();
//    }
//
//    public List<ContactsEntity> getContactByName(String name){
//        return entityManager.createNamedQuery(
//                "Contacts.getContactByName",
//                ContactsEntity.class)
//                .setParameter("name", name)
//                .getResultList();
//    }
//
//    public void resetContactTimer(int contactID){
//        entityManager.createQuery(
//                "update contacts set last_contact = CURDATE() where contact_id = :contact_id",
//                ContactsEntity.class)
//                .setParameter("contact_id", contactID)
//                .getResultList();
//    }
{}

//    @Autowired
//    public ContactDAO(DataSource dataSource){
//        this.setDataSource(dataSource);
//    }
//
//    public User findUserAccount(String userName){
//        //SELECT username FROM contactUsers where username=?
//        String sql = UserMapper.selectInfo + "where u.username = ?";
//
//        Object[] parameters = new Object[] { userName };
//        UserMapper mapper = new UserMapper();
//        try {
//            User userInfo = this.getJdbcTemplate().queryForObject(sql, parameters, mapper);
//            return userInfo;
//        } catch (EmptyResultDataAccessException e){
//            return null;
//        }
//    }
}
