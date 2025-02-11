package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequest;
import com.example.schedule.domain.Schedule;
import com.example.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    // 생성자 주입으로 ScheduleService를 받아옴
    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    // 일정 생성 API
    @PostMapping("/create")
    public ResponseEntity<String> createSchedule(@RequestBody ScheduleRequest request) {
        scheduleService.createSchedule(request); // ScheduleService를 통해 일정 생성 처리
        return ResponseEntity.ok("일정이 성공적으로 생성되었습니다."); // 일정 생성 완료 후 성공 메시지 반환
    }
    // 일정 수정 API (ID로 수정)
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable Long id) {
        Schedule schedule = scheduleService.getSchedule(id); // 주어진 ID로 일정 수정
        return ResponseEntity.ok(schedule); // 일정 수정 완료 후 성공 메시지 반환
    }
    // 일정 수정 API (ID로 수정)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequest request) {
        scheduleService.updateSchedule(id, request); // 주어진 ID로 일정 수정
        return ResponseEntity.ok("일정이 성공적으로 수정되었습니다."); // 일정 수정 완료 후 성공 메시지 반환
    }
    // 일정 삭제 API (ID로 삭제)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id); // 주어진 ID로 일정 삭제
        return ResponseEntity.ok("일정이 성공적으로 삭제되었습니다."); // 일정 삭제 완료 후 성공 메시지 반환
    }
    // 모든 일정 조회 API
    @GetMapping("/all")
    public ResponseEntity<List<Schedule>> getSchedules() {
        List<Schedule> schedules = scheduleService.getSchedules(); // 모든 일정 목록 조회
        return ResponseEntity.ok(schedules); // 조회된 일정 목록 반환
    }
}