/*
 *  Copyright (c) 2017-2027 Quartz Insight
 *  This file is part of projects developed by Quartz Insight.
 *  Projects developed by Quartz Insight can not be copied and/or distributed without the express permission of Quartz Insight.
 */
package com.quartzinsight.qieam.persistence.db;

import com.quartzinsight.qieam.model.Game;
import com.quartzinsight.qieam.model.Games;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoreDaoInPgSqlTest {

    private static final String ENV = "DATABASE_URL_TEST";

    public StoreDaoInPgSqlTest() {
    }

    @Before
    public void resetDb() {
        MetadataPgSql.resetDb(ENV);
        if (System.getenv(ENV) == null) {
            return;
        }
        MetadataPgSql.resetDb(ENV);
    }

    @Test
    public void testGetGames() {
        if (System.getenv(ENV) == null) {
            return;
        }
        StoreDaoInPgSql instance = StoreDaoInPgSql.getInstance(ENV);
        Games expected = new Games();
        expected.addGame(new Game("cyberpunk"));
        Games result = instance.getGames();
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getGames());
        Assert.assertEquals(expected.getGames().size(), result.getGames().size());
        Assert.assertTrue(expected.getGames().containsAll(result.getGames()));
        Assert.assertTrue(result.getGames().containsAll(expected.getGames()));
    }

}
