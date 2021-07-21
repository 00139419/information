package com.morales.daniel.myapplication12th.data.Reposity

import com.morales.daniel.myapplication12th.data.dao.TermDao
import com.morales.daniel.myapplication12th.data.entity.Term

class TermRepository(private val termDao: TermDao) {
suspend fun insert_or_replace(term: Term) = termDao.insert_or_replace(term)
}