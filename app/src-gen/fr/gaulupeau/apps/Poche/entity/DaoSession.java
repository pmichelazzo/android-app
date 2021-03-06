package fr.gaulupeau.apps.Poche.entity;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import fr.gaulupeau.apps.Poche.entity.Article;
import fr.gaulupeau.apps.Poche.entity.QueueItem;

import fr.gaulupeau.apps.Poche.entity.ArticleDao;
import fr.gaulupeau.apps.Poche.entity.QueueItemDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig articleDaoConfig;
    private final DaoConfig queueItemDaoConfig;

    private final ArticleDao articleDao;
    private final QueueItemDao queueItemDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        articleDaoConfig = daoConfigMap.get(ArticleDao.class).clone();
        articleDaoConfig.initIdentityScope(type);

        queueItemDaoConfig = daoConfigMap.get(QueueItemDao.class).clone();
        queueItemDaoConfig.initIdentityScope(type);

        articleDao = new ArticleDao(articleDaoConfig, this);
        queueItemDao = new QueueItemDao(queueItemDaoConfig, this);

        registerDao(Article.class, articleDao);
        registerDao(QueueItem.class, queueItemDao);
    }
    
    public void clear() {
        articleDaoConfig.getIdentityScope().clear();
        queueItemDaoConfig.getIdentityScope().clear();
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public QueueItemDao getQueueItemDao() {
        return queueItemDao;
    }

}
