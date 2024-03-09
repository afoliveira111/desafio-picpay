package com.picpay.desafio.android



//class UserRepositoryImpl(private val picPayService: PicPayService) : UserRepository {
//
//    override suspend fun getUsers(): List<User>? {
//        return try {
//            val response = picPayService.getUsers().execute()
//
//            if (response.isSuccessful) {
//                response.body()
//            } else {
//                null
//            }
//        } catch (e: Exception) {
//            null
//        }
//    }
//}