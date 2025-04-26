package com.report.impl;

import org.springframework.stereotype.Service;

import com.report.entities.Feedback;
import com.report.repository.FeedbackRepo;
import com.report.services.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private  FeedbackRepo feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepo feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElseThrow(() -> new RuntimeException("Feedback not found"));
    }

    @Override
    public Feedback updateFeedback(Long id, Feedback feedback) {
        Feedback obj= feedbackRepository.findById(id).orElseThrow(()-> new RuntimeException("not found object with id "+ id));
        obj.setComments(feedback.getComments());
        obj.setSubmittedAt(feedback.getSubmittedAt());
        return feedbackRepository.save(obj);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id) ;
        System.out.println("successfully deleted");
    }
}
