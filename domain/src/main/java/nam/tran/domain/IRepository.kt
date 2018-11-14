package nam.tran.domain

import androidx.lifecycle.LiveData
import nam.tran.domain.entity.ComicEntity
import nam.tran.domain.entity.state.Listing
import nam.tran.domain.entity.state.Resource

interface IRepository {

    fun getComic(offset : Int, count : Int,typeLoading : Int): LiveData<Resource<List<ComicEntity>>>

    fun getComic(convert: (List<ComicEntity>) -> List<Any>): LiveData<Listing<Any>>
}
