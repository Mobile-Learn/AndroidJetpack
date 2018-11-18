package nam.tran.domain.interactor

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import nam.tran.domain.entity.BaseItemKey
import nam.tran.domain.entity.ComicEntity
import nam.tran.domain.mapper.DataEntityMapper
import nam.tran.flatform.IApi
import tran.nam.util.Logger
import java.util.concurrent.Executor

class ItemComicDataSourceFactory(
    private val iApi: IApi,
    private val dataEntityMapper: DataEntityMapper,
    private val convert: (List<ComicEntity>) -> List<BaseItemKey>
) : DataSource.Factory<Int, BaseItemKey>() {

    val sourceLiveData = MutableLiveData<ItemKeyedComicDataSource>()

    override fun create(): DataSource<Int, BaseItemKey> {
        Logger.debug("Paging Learn","PageDataSourceFactory - create()")
        val source = ItemKeyedComicDataSource(iApi, dataEntityMapper,convert)
        sourceLiveData.postValue(source)
        return source
    }

}