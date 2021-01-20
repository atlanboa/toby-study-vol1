package user.service;

import user.dao.UserDao;
import user.domain.Level;
import user.domain.User;

public class SummerUserLevelUpgradePolicy implements UserLevelUpgradePolicy{
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC: return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER: return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
            case GOLD: return false;
            default: throw new IllegalArgumentException("unknown Level : "+currentLevel);
        }
    }

    @Override
    public void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }
}