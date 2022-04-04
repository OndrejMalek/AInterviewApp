package eu.malek.alliants.interview.net

import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import com.google.gson.Gson
import org.junit.Test


class CmsApiRepoTest{

    @Test
    fun getVendors() {

        assertThat(CmsApiRepo().getVendorList()
            .blockingFirst()
            .body()
            .let {
                Gson().toJsonTree(it).asJsonArray
                    .mapIndexed {
                            index, element ->
                        element
                    }
                    .take(2)
            }

        ).isEqualTo("")
    }

    @Test
    fun getVendors2() {
        assertThat(CmsApiRepo().getVendorList().blockingFirst().body()).isNotEmpty()
    }
}