package eu.malek.alliants.interview.net

import com.google.common.truth.Truth.assertThat
import org.junit.Ignore
import org.junit.Test


class CmsApiRepoTest{


    @Test
    @Ignore
    //TODO it can be done some schema checking here, depends on how static API is/ CD capabilities
    fun getVendors2() {
        assertThat(CmsApiRepo().getVendorList().blockingFirst().body()).isNotEmpty()
    }
}