package eu.malek.alliants.interview.net

import eu.malek.alliants.interview.net.CmsApi.Companion.createService

class CmsApiRepo(service :CmsApi = createService()): CmsApi by service {

}
